package com.saurabhSeleniumAuto.ex_selenium_24_Data_driven_testing_and_Apache_POI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class CellCreate_at_specific_position {

    public static void main (String []args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");

        Row row = sheet.createRow(1);
        Cell cell = row.createCell(1);
        cell.setCellValue("MR. Saurabh");




        FileOutputStream outputStream = new FileOutputStream(new File("U_CellAtSpecific.xlsx"));
        workbook.write(outputStream);
        outputStream.close();


    }
}