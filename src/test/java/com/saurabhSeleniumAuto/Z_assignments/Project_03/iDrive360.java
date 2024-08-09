package com.saurabhSeleniumAuto.Z_assignments.Project_03;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class iDrive360 {
    @Test
    @Description("TC1, To verify the login ")
    public static void testLoginiDrive360(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        //options.addArguments("--start-maximized");
        options.addArguments("window-size=500,700");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        EdgeDriver driver =new EdgeDriver(options);
        driver.get("https://www.idrive360.com/enterprise/login");
        Assert.assertEquals(driver.getTitle(),"IDrive® 360 - Sign in to your account");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.idrive360.com/enterprise/login");


        WebElement username = driver.findElement(By.id("username"));;
        username.sendKeys("augtest_040823@idrive.com");

        WebElement password = driver.findElement(By.id("password"));;
        password.sendKeys("123456");

        WebElement chkbox = driver.findElement(By.className("id-checkmark"));
        chkbox.click();

        WebElement sgnBtn = driver.findElement(By.id("frm-btn"));
        sgnBtn.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

        driver.quit();
        System.out.println("Able to do the Login ");


    }

    @Test
    @Description("TC2, To verify the Trial ")
    public static void testTrialiDrive360(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
       // options.addArguments("--start-maximized");
        options.addArguments("window-size=500,700");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        EdgeDriver driver =new EdgeDriver(options);
        driver.get("https://www.idrive360.com/enterprise/login");
//        Assert.assertEquals(driver.getTitle(),"IDrive® 360 - Sign in to your account");
//        Assert.assertEquals(driver.getCurrentUrl(),"https://www.idrive360.com/enterprise/login");


        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("augtest_040823@idrive.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123456");

        WebElement chkbox = driver.findElement(By.className("id-checkmark"));
        chkbox.click();

        WebElement sgnBtn = driver.findElement(By.id("frm-btn"));
        sgnBtn.click();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

        Assert.assertEquals(driver.getTitle(),"IDrive 360 account details");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.idrive360.com/enterprise/account?upgradenow=true");

        WebElement txtMsg = driver.findElement(By.cssSelector(".id-card-cont .id-card-title"));
        String txtMsg_Heading = txtMsg.getText();
        Assert.assertEquals("Your free trial has expired", txtMsg_Heading);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

        driver.quit();
        System.out.println("Able to verify the trial");


}
}
