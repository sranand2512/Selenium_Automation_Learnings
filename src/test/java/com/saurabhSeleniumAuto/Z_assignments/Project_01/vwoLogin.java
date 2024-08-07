package com.saurabhSeleniumAuto.Z_assignments.Project_01;

import io.qameta.allure.Description;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class vwoLogin {

    @Test
    @Description("Test case 1, To verify the login with correct username and password")
    public void testvwoLoginpositive(){
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

//        WebElement remembermeCheckBox = driver.findElement(By.partialLinkText("#icon--checkbox-button"));
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


        driver.quit();
    }


}
