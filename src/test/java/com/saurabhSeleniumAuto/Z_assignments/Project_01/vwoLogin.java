package com.saurabhSeleniumAuto.Z_assignments.Project_01;

import io.qameta.allure.Description;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

public class vwoLogin {

    @Test
    @Description("Test case 1, To verify the login with correct username and password")
    public void testvwoLoginpositive() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        EdgeDriver driver = new EdgeDriver(options);
        driver.get("https://app.vwo.com/");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

        WebElement emailInputField = driver.findElement(By.id("login-username"));
        emailInputField.sendKeys("fiviwof416@morxin.com");

        WebElement passwordInputField = driver.findElement(By.id("login-password"));
        passwordInputField.sendKeys("Test1234567");

//        WebElement remembermeCheckBox = driver.findElement(By.id("checkbox-remember"));
//        remembermeCheckBox.click();

        WebElement signInButton = driver.findElement(By.id("js-login-btn"));
        signInButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/dashboard");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


        @Test
        @Description("Test case 2, To verify the Name on the Dashboard")
        public void testNameonDashboard () {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--guest");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

            EdgeDriver driver = new EdgeDriver(options);
            driver.get("https://app.vwo.com/");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");
           // Assert.assertEquals(driver.getTitle(), "Login - VWO");

            WebElement emailInputField = driver.findElement(By.id("login-username"));
            emailInputField.sendKeys("fiviwof416@morxin.com");

            WebElement passwordInputField = driver.findElement(By.id("login-password"));
            passwordInputField.sendKeys("Test1234567");

//            WebElement remembermeCheckBox = driver.findElement(By.id("checkbox-remember"));
//            remembermeCheckBox.click();

            WebElement signInButton = driver.findElement(By.id("js-login-btn"));
            signInButton.click();

            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/dashboard");
            Assert.assertEquals(driver.getTitle(), "Dashboard");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement greetingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-qa='lufexuloga']")));


            String actualGreetingText = greetingElement.getText();
            assertThat(actualGreetingText, Matchers.containsString("test one"));

            driver.quit();
            

        }

    }