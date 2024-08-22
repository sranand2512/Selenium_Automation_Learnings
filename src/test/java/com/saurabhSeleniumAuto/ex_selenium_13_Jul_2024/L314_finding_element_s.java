package com.saurabhSeleniumAuto.ex_selenium_13_Jul_2024;


import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;


public class L314_finding_element_s {
    @Test
    public void testFreeTrial()  {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);


        WebDriver driver = new EdgeDriver(options);
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");
        //driver.manage().window().maximize();


        // If we do not have ID, class, name, css then we can use linkText
        // Link text and partial link text but it will work in a tag ie anchor tag
        // WebElement freeTrial = driver.findElement(By.linkText("Start a free trial"));
        WebElement freeTrial = driver.findElement(By.partialLinkText("Start a free"));
        freeTrial.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement enterEmail = driver.findElement(By.id("page-v1-step1-email"));
        enterEmail.sendKeys("anand@yopmail.com");

        WebElement clickCheckbox = driver.findElement(By.name("gdpr_consent_checkbox"));
        clickCheckbox.click();

       // WebElement clickCreateFreeTrial = driver.findElement(By.className("button W(100%) btn-modal-form-submit"));
       // clickCreateFreeTrial.click();

        List<WebElement> buttonnlist = driver.findElements(By.tagName("button"));
        buttonnlist.get(0).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement errorMessage =  driver.findElement(By.className("invalid-reason"));
        System.out.println(errorMessage.getText());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        Assert.assertEquals(errorMessage.getText(), "yopmail.com doesn't look like a business email. Please use your business email");



        driver.quit();;
    }
}
