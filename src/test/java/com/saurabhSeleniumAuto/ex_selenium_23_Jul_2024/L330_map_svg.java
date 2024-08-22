package com.saurabhSeleniumAuto.ex_selenium_23_Jul_2024;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class L330_map_svg {
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
    @Description("Test Case svg")
    public void testsvgElement() {
        String URL = "https://www.amcharts.com/svg-maps/?map=india";
        driver.get(URL);

        WebElement element = driver.findElement(By.xpath("//input[@class=\"button\"]"));
        element.click();

//        Alert alert = driver.switchTo().alert();
//        alert.accept();

        //svg = Scalable vector graphics
        //made with path, circle, square etc.

        //*[local-name()="svg"]
        //*[name()="svg"]
        //*[contains()="svg"]
        WebElement state = driver.findElement(By.xpath("//*[name()=\"svg\"]/*[name()=\"g\"][7]/*[name()=\"g\"]/*[name()=\"g\"]/*[@aria-label =\"Bihar  \"]"));
        state.click();

        List <WebElement> all_states = driver.findElements(By.xpath("//*[name()=\"svg\"]/*[name()=\"g\"][7]/*[name()=\"g\"]/*[name()=\"g\"]/*[name()=\"path\"]"));
        for (int i = 0; i < all_states.size(); i++) {
            System.out.println(all_states.get(i).getAttribute("aria-label"));

        }


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


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

