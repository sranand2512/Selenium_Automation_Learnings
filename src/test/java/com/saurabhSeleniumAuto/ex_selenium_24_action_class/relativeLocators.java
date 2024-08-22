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
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class relativeLocators {

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
    @Description("Test Case for relativeLocators")
    public void testrelativeLocators() {
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);

        WebElement span_element = driver.findElement(By.xpath("//*[text()='Years of Experience']"));
        driver.findElement(with(By.id("exp-0")).toRightOf(span_element)).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @AfterTest
    public void closeBrowser() {

        driver.quit();
    }

}



