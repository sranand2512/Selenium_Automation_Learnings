package com.saurabhSeleniumAuto.Z_assignments.Project_01;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

public class tvwoLogin {

    @Test
    public void loginWithValid() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://app.vwo.com/#/login");

        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("vwo@1secmail.com");

        WebElement pass = driver.findElement(By.id("login-password"));
        pass.sendKeys("Vwo@1234");

        WebElement rememberME = driver.findElement(By.id("checkbox-remember"));
        rememberME.click();

        WebElement click_button = driver.findElement(By.id("js-login-btn"));
        click_button.click();

        // Wait for the dashboard to load and the greeting text to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement greetingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-qa='lufexuloga']")));

        // Retrieve the text and assert it
        String actualGreetingText = greetingElement.getText();
        assertThat(actualGreetingText, Matchers.containsString("V M"));

        driver.quit();
    }
}
