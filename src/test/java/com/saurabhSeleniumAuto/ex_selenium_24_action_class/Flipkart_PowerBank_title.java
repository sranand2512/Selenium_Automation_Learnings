package com.saurabhSeleniumAuto.ex_selenium_24_action_class;

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

public class Flipkart_PowerBank_title {

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
    @Description("Test Case for printing the heading of PowerBank ")
    public void testPrintPowerBank() {
        String URL = "https://www.flipkart.com/";
        driver.get(URL);
        //svg = Scalable vector graphics
        //made with path, circle, square etc.

        //*[local-name()="svg"]
        //*[name()="svg"]
        //*[contains()="svg"]

        driver.findElement(By.xpath("//div[@aria-label=\"Electronics\"]")).click();

        List<WebElement> svgElement = driver.findElements(By.xpath("//*[name()=\"svg\"]"));
        svgElement.get(0).click();

        List<WebElement> search_result = driver.findElements(By.xpath("//*[@class = \"cPHDOP col-12-12\"]"));
        for (int i = 0; i < search_result.size(); i++) {
            System.out.println(search_result.get(i).getText());
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

