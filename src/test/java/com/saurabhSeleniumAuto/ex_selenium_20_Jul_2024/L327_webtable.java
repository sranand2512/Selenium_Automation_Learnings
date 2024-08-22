package com.saurabhSeleniumAuto.ex_selenium_20_Jul_2024;

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

public class L327_webtable {
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
    @Description("Test Case Webtable")
    public void testWebTable() {
        String URL = "https://awesomeqa.com/webtable.html";
        driver.get(URL);

        // Want to print all the data table
        // Want to know the country where helen belongs to

        int row = driver.findElements(By.xpath("//table[@id = 'customers']/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id = 'customers']/tbody/tr[2]/td")).size();


        String first_part = "//table[@id = 'customers']/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        for (int i = 2; i < row; i++) {
            for (int j = 1; j < col; j++) {

                String dynamic_path = first_part + i + second_part + j + third_part;
                String data = driver.findElement(By.xpath(dynamic_path)).getText();
//                System.out.println(data);

                if (data.contains("Helen Bennett")) {
                    String path = dynamic_path + "/following-sibling::td";
                    String country = driver.findElement(By.xpath(path)).getText();
                    System.out.println("\n" + country + "   where Helen belongs to.");
                }

                if (data.contains("Helen Bennett")) {
                    String Co_path = dynamic_path + "/preceding-sibling::td";
                    String Co_country = driver.findElement(By.xpath(Co_path)).getText();
                    System.out.println("\n" + Co_country + "  where Helen is working.");

                }
            }
        }
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