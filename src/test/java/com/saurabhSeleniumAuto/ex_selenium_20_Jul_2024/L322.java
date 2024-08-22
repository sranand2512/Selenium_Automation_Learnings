package com.saurabhSeleniumAuto.ex_selenium_20_Jul_2024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.saurabhSeleniumAuto.ex_selenium_20_Jul_2024.WaitHelpers.checkVisiblity;

public class L322 {

    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testVerifyFREETrial() throws InterruptedException {

        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();


        driver.findElement(By.id("login-username")).sendKeys("fiviwof416@morxin.com");
        driver.findElement(By.id("login-password")).sendKeys("Test1234567");
        driver.findElement(By.id("js-login-btn")).click();


        // Explicit wait

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='lufexuloga']")));

        // Explicit wait function
        checkVisiblity(driver,(By.cssSelector("[data-qa='lufexuloga']")));

        WebElement Loggedin_user = driver.findElement(By.cssSelector("[data-qa='lufexuloga']"));
        System.out.println("User is :"+ Loggedin_user.getText());
        Assert.assertEquals(Loggedin_user.getText(),"test one");




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
