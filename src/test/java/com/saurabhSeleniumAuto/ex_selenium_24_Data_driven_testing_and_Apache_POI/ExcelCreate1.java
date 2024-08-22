package com.saurabhSeleniumAuto.ex_selenium_24_Data_driven_testing_and_Apache_POI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExcelCreate1 {
    public static void main(String[] args) throws IOException {
        // Workbook
        // Sheet
        // Row, Cell
        // XSSFWorkbook - xslx after 2008
        // HSSFWorkbook - xls before 2004

        // Test is to create an Excel file, add data and also use as utility

        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"LoginID", "Email", "Password"});
        data.put("2", new Object[]{"1", "pramod@123.com", "123456"});
        data.put("3", new Object[]{"2", "new@123.in", "test123"});

        String filePath = createExcel("User_2.xlsx", data);
        System.out.println("Excel file created at: " + filePath);
    }

    public static String createExcel(String name, Map<String, Object[]> data) throws IOException {
        Set<String> keyset = data.keySet();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");

        int rownum = 0;

        for (String key : keyset) {
            Row r = sheet.createRow(rownum++);
            Object[] objectA = data.get(key);

            int cellnum = 0;
            for (Object o : objectA) {
                Cell cell = r.createCell(cellnum++);
                if (o instanceof String) {
                    cell.setCellValue((String) o);
                } else if (o instanceof Integer) {
                    cell.setCellValue((Integer) o);
                }
            }
        }

        // Save the file in the current directory or specify a complete path
        String filePath = new File(name).getAbsolutePath();
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.close();
        workbook.close(); // Close the workbook to free up resources
        return filePath;
    }
}
