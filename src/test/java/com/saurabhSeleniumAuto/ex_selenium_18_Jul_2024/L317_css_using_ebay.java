package com.saurabhSeleniumAuto.ex_selenium_18_Jul_2024;

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
import java.util.concurrent.TimeUnit;

public class L317_css_using_ebay {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);

    }

    @Test(groups = "QA")
    @Description("Search macmini on ebay and verify and print all the details")
    public void testEbayMacmini() {
        driver.get("https://www.ebay.com/");

        WebElement searchBox = driver.findElement(By.cssSelector("input[id=\"gh-ac\"]"));
        searchBox.sendKeys("macmini");

        WebElement searchBtn = driver.findElement(By.cssSelector("input[id=\"gh-btn\"]"));
        searchBtn.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> searchHeading = driver.findElements(By.cssSelector("*[class='s-item__title']"));
        List<WebElement> searchPrize = driver.findElements(By.cssSelector("[class=\"s-item__price\"]"));
//        for(WebElement title : searchHeading){
//            System.out.println(title.getText());
//        }
//        int totalResults = searchHeading.size();
//        for (int i = 0; i < totalResults; i++) {
//            System.out.println(searchHeading.get(i).getText()+ "\n");
//        }
//
//        int totalResults1 = searchPrize.size();
//        for (int i = 0; i < totalResults1; i++) {
//            System.out.println(searchPrize.get(i).getText()+ "\n");
//        }

//        int size = Math.min(searchHeading.size(),searchPrize.size());
//        for (int i = 0; i < size; i++) {
//            System.out.println(searchHeading.get(i).getText());
//            System.out.println(searchPrize.get(i).getText() + "\n");
//
//        }
        int size = Math.min(searchHeading.size(), searchPrize.size());
        for (int i = 0; i < size; i++) {
            System.out.println(searchHeading.get(i).getText() +"Price "+ searchPrize.get(i).getText());
        }

        // img[title*="Flip"] - contains
        // img[title^="Flip"] - starts-wiht
        // img[title$="Flip"] - end-with
        // div.first > span:nth-child(2n+1)
        // div.first > span


        // Select -> simple, custom Select(div, ui-li) - different appraoch)


        // Why Do We Need Waits In Selenium?
        // do this
        // Thread.sleep(3) - JVM to stop the execution - Worst type wait. - Halt JVM
        // do that


        // Implicit Wait - Bad
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Gives No Such Element Exception.

    }
        @AfterTest
        public void closeBrowser() {
            driver.quit();
        }


}
