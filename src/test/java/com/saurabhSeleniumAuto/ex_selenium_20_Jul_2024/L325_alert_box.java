package com.saurabhSeleniumAuto.ex_selenium_20_Jul_2024;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class L325_alert_box {
    EdgeDriver driver;

    @BeforeMethod
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case for alertbox")
    public void testAlertBox() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());
//        driver.manage().window().maximize();

        WebElement okAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        okAlert.click();

//        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.alertIsPresent());

        Thread.sleep(5000);

        Alert alert = driver.switchTo().alert();
       // alert.accept();
        alert.dismiss();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You successfully clicked an alert");

    }
    @Test(groups = "QA")
    @Description("Test Case for alertboxConfirm")
    public void testAlertBoxConfirm() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());
//        driver.manage().window().maximize();

        WebElement okAlert = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        okAlert.click();

//        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.alertIsPresent());

        Thread.sleep(5000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        //alert.dismiss();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You clicked: Ok");

    }

    @Test(groups = "QA")
    @Description("Test Case for alertboxPrompt")
    public void testAlertBoxPrompt() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());
//        driver.manage().window().maximize();

        WebElement okAlert = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        okAlert.click();

//        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.alertIsPresent());

        Thread.sleep(5000);

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Saurabh");
        alert.accept();
        //alert.dismiss();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You entered: Saurabh");

    }

    @AfterMethod
    public void closeBrowser() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}

