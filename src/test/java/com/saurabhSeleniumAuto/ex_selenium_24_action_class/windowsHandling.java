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

import java.util.List;
import java.util.Set;

public class windowsHandling{

    EdgeDriver driver;
    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
       // options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case for windowsHandling")
    public void windowsHandling() {
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String mainWindowsHandle = driver.getWindowHandle();
        System.out.println("Before click "+mainWindowsHandle);

        WebElement linkText = driver.findElement(By.linkText("Click Here"));
        linkText.click();

        Set<String> windowsHandles = driver.getWindowHandles();
        // Set is used because windows each tab has unique name
        for (String handle : windowsHandles){
            //for switching to new windows
            driver.switchTo().window(handle);
            System.out.println(handle);
            if (driver.getPageSource().contains("New Windows")){
                // Basically new windows is written on second window that we ar opening means content is new window
                System.out.println("TC Pass");
            }
        }
        driver.switchTo().window(mainWindowsHandle);

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


