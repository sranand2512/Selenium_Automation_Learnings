package com.saurabhSeleniumAuto.ex_selenium_13_Jul_2024;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class L309 {
    public static void main(String[] args) throws InterruptedException {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        WebDriver  driver = new EdgeDriver(options);
        driver.get("https://www.facebook.com");
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
