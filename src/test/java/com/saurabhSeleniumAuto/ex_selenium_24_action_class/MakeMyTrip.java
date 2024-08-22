package com.saurabhSeleniumAuto.ex_selenium_24_action_class;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class MakeMyTrip {

    EdgeDriver driver;
    @BeforeTest
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case for MakeMyTrip")
    public void MakeMyTrip() {
        String URL = "https://www.makemytrip.com/";
        driver.get(URL);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement closeModel = driver.findElement(By.className("commonModal__close"));
        closeModel.click();

        WebElement source = driver.findElement(By.id("fromCity"));

        Actions action = new Actions(driver);
        action.moveToElement(source).click().sendKeys("PATNA").build().perform();

        List<WebElement> Auto_Suggestion = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']"));
//        for (WebElement e : Auto_Suggestion){
//            if(e.getText().contains("Patna")){
//                e.click();
//                break;
//            }
//        }
        for (int i = 0; i < Auto_Suggestion.size(); i++) {
            if(Auto_Suggestion.get(i).getText().contains("Patna")){
                Auto_Suggestion.get(i).click();

            }

        }

        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();



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


