package com.saurabhSeleniumAuto.ex_selenium_24_action_class;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class stale_element_selenium_exception {

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
    @Description("Test Case for iframe error message validation ")
    public void staleelement() {
        String URL = "https://www.google.com/";
        driver.get(URL);
        // basically stale element exception said if we find the element and search the result and it is availble
        // but also you refresh it and trying to find the same result in same element then it will give the stale element error.

        WebElement search = driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
        search.sendKeys("The Testing Academy" + Keys.ENTER);
        driver.navigate().refresh();
        search.sendKeys("The Testing Academy" + Keys.ENTER);
        // this wil give the error in case of refresh, navigate other page, element removed, change in dom element (ajax calls )- VeuJS and AngularJS

        // But if we do it again finding and the search then it will not give
//        WebElement search1 = driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
//        search1.sendKeys("The Testing Academy" + Keys.ENTER);

        //can handle like
//        try{
//
//            WebElement search = driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
//            search.sendKeys("The Testing Academy" + Keys.ENTER);
//            driver.navigate().refresh();
//            search.sendKeys("The Testing Academy" + Keys.ENTER);
//        }catch (StaleElementReferenceException ex){
//           // catch (StaleElementReferenceException | NoSuchElementException ex){
//            System.out.println(ex.getMessage());
//        }




        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @AfterTest
    public void closeBrowser() {

        driver.quit();
    }

}



