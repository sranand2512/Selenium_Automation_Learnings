package com.saurabhSeleniumAuto.ex_selenium_24_action_class;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class L332_ActionClass {
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
        @Description("Test Case for ActionClassEG ")
        public void testActionClassEG() {
            String URL = "https://awesomeqa.com/practice.html";
            driver.get(URL);

            WebElement inputFirstname = driver.findElement(By.xpath("//input[@name='firstname']"));

            // enter the details in caps
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.SHIFT).sendKeys(inputFirstname, "saurabh").keyUp(Keys.SHIFT).build().perform();

            //right click on any item
            WebElement contextClick = driver.findElement(By.xpath("//a[text()='Click here to Download File']"));
            actions.contextClick().build().perform();

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


