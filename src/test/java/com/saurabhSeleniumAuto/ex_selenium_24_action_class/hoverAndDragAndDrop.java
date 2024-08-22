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

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class hoverAndDragAndDrop {

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
    @Description("Test Case for VWO_UsingHover")
    public void VWO_UsingHover() {
        String URL = "https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1";
        driver.get(URL);

        String mainWindowsHandle = driver.getWindowHandle();
        System.out.println("Before click "+mainWindowsHandle);

        Actions actions = new Actions(driver);
        List<WebElement> list_hashmaps  = driver.findElements(By.cssSelector("[id=\"js-heatmap-thumbnail\"]"));
        actions.moveToElement(list_hashmaps.get(1)).click().build().perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Set<String> windowsHandles = driver.getWindowHandles();
        System.out.println(windowsHandles);

        Iterator<String> iterator = windowsHandles.iterator();
        while(iterator.hasNext()){
            String childWindow= iterator.next();
            if(!mainWindowsHandle.equalsIgnoreCase((childWindow))){
                driver.switchTo().window(childWindow);
                System.out.println(driver.getTitle());
            }
        }


    }

    @AfterTest
    public void closeBrowser() {

        driver.quit();
    }

}


