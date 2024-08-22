package com.saurabhSeleniumAuto.ex_selenium_23_Jul_2024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class L328_dynamic_webtable {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case Webtable_dynamic")
    public void testWebTable_dynamic() {
        String URL = "https://awesomeqa.com/webtable1.html";
        driver.get(URL);

        WebElement table = driver.findElement(By.xpath("//table[@summary ='Sample Table']/tbody"));
        List<WebElement> row_table = driver.findElements(By.tagName("tr"));

        for (WebElement row : row_table) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.println(col.getText());
            }
        }

//        for (int i = 0; i < row_table.size(); i++) {
//            List<WebElement> cols = row_table.get(i).findElements(By.tagName("td"));
//            for (int j = 0; j < cols.size(); j++) {
//                System.out.println(cols.get(j).getText());
//            }
//        }

//        for (int i = 0; i < row_table.size(); i++) {
//            List<WebElement> col =row_table.get(i).findElements(By.tagName("td"));
//
//            for (int j = 1; j < row_table.size(); j++) {
//                System.out.println(col.get(i).getText());
//
//            }






    }


    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
