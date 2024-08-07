package com.saurabhSeleniumAuto.ex_selenium_11_Jul_2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class L305 {
    @Test
    public void testvwologin(){
        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://app.vwo.com");
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        driver.quit();


    }
}
