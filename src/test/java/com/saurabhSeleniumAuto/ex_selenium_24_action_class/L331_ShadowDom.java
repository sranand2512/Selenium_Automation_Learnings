package com.saurabhSeleniumAuto.ex_selenium_24_action_class;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class L331_ShadowDom {
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
    @Description("Test Case for Shadow DOM ")
    public void testEnterPizza() {
        String URL = "https://selectorshub.com/xpath-practice-page/";
        driver.get(URL);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement scrollTo = driver.findElement(By.xpath("//div[@id = \"userName\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);",scrollTo);



        // Java Script code : document.querySelector("div#userName").shadowRoot.querySelector("div").shadowRoot.querySelector("input#pizza")


        WebElement element = (WebElement) js.executeScript(" return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div\").shadowRoot.querySelector(\"input#pizza\")\n");
        element.sendKeys("Onion slice Pizza");



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
