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

public class L329_svg {
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
    @Description("Test Case svg")
    public void testsvgElement() {
        String URL = "https://www.flipkart.com/";
        driver.get(URL);
        //svg = Scalable vector graphics
        //made with path, circle, square etc.

        //*[local-name()="svg"]
        //*[name()="svg"]
        //*[contains()="svg"]

        driver.findElement(By.name("q")).sendKeys("moto g34 5g");
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

