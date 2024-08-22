package com.saurabhSeleniumAuto.ex_selenium_13_Jul_2024;


import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class L313_finding_element_linktext {
    @Test
    public void testVwoLogin()  {
        // Project 01, TC Negative, invalid username/password

        // Oen the url app.vwo.com/#/login
        // Find the Email Id and enter the email email@email.com
        // Find the input box and enter the password pass@123
        // Verify the error message shown " Your email, password, IP address or location did not match"


        // Question is how to find
        //<input
        // type="password"
        // class="text-input W(100%)"
        // name="password"
        // id="login-password"
        // data-qa="jobodapuxe"
        // >
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);


        WebDriver driver = new EdgeDriver(options);
        driver.get("https://app.vwo.com");
       // driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("email@email.com");


        WebElement passwordInputBox = driver.findElement(By.id("login-password"));
        passwordInputBox.sendKeys("pass@123");


        WebElement submitButton = driver.findElement(By.id("js-login-btn"));
        submitButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Verify the error message
        // WebElement errorMessage = driver.findElement(By.className("notification-box-description"));
        WebElement errorMessage = driver.findElement(By.id("js-notification-box-msg"));
        Assert.assertEquals(errorMessage.getText(), "Your email, password, IP address or location did not match");

        // If we do not have ID, class, name, css then we can use linkText
        // Link text and partial link text but it will work in a tag ie anchor tag
        // WebElement freeTrial = driver.findElement(By.linkText("Start a free trial"));
        WebElement freeTrial = driver.findElement(By.partialLinkText("Start a free"));
        freeTrial.click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();;
    }
}
