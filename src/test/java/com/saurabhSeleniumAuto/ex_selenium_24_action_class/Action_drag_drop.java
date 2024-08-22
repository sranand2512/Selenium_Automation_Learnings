package com.saurabhSeleniumAuto.ex_selenium_24_action_class;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.util.List;

public class Action_drag_drop {

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
    @Description("Test Case for Drag_and_drop")
    public void Drag_and_drop() {
        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);

       // WebElement closeModel = driver.findElement(By.className("commonModal__close"));
       // closeModel.click();

        Actions actions =new Actions(driver);
        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));
//        actions.dragAndDrop(from,to).perform();

        actions.clickAndHold(from).moveToElement(to).release().build().perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

        @Test(groups = "QA")
        @Description("Test Case for uploadFile")
        public void uplodFile() {
            String URL = "https://awesomeqa.com/selenium/upload.html";
            driver.get(URL);
            // selenium can only handel the file uplod if its type in input

            WebElement inputUpload = driver.findElement(By.id("fileToUpload"));
            inputUpload.sendKeys("C:\\Users\\sanan\\IdeaProjects\\Selenium_Automation_Learnings\\src\\test\\java\\com\\saurabhSeleniumAuto\\ex_selenium_24_action_class\\Saurabh.txt");

            WebElement submitBtn = driver.findElement(By.name("submit"));
            submitBtn.click();


        }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

}


