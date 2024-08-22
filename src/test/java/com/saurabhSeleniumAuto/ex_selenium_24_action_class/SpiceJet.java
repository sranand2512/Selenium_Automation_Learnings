package com.saurabhSeleniumAuto.ex_selenium_24_action_class;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SpiceJet {

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
    @Description("Test Case for SpiceJet")
    public void testSpiceJet() {
        String URL = "https://www.spicejet.com/";
        driver.get(URL);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement source = driver.findElement(By.xpath("//div[@data-testid='search-source-city-txt']"));

        Actions action = new Actions(driver);
        action.moveToElement(source).click().build().perform();
        action.moveToElement(source).click().sendKeys("PAT").build().perform();



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


