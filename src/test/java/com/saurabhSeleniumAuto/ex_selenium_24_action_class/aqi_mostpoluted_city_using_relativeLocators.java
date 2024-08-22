package com.saurabhSeleniumAuto.ex_selenium_24_action_class;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class aqi_mostpoluted_city_using_relativeLocators {

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
    @Description("Test Case for aqi_mostpoluted_city_using_relativeLocators")
    public void aqi_mostpoluted_city_using_relativeLocators() {
        String URL = "https://www.aqi.in/real-time-most-polluted-city-ranking";
        driver.get(URL);

        WebElement search_country  = driver.findElement(By.id("search_city"));
        search_country.sendKeys("India" + Keys.ENTER);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> table = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
        for (WebElement l : table){
            String city = l.getText();
            String aqi = driver.findElement(with(By.tagName("p")).toRightOf(l)).getText();
            String ranking = driver.findElement(with(By.tagName("p")).toLeftOf(l)).getText();

            if (city.equalsIgnoreCase("Noida")){
                System.out.println("Ranking is  " + ranking + " and  " + "AQI is  " + aqi + "  " + "of city  " + city);
            }
        }


//        WebElement city_name= driver.findElement(with(By.xpath("//table[@id='example']/tbody/tr[2]/td[2]/div[1]/p[1]")).toRightOf(table));
//        city_name.click();
//        System.out.println(city_name.getText());

        //tbody/tr[2]/td[2]/div[1]/p[1]



    }

    @AfterTest
    public void closeBrowser() {

        driver.quit();
    }

}



