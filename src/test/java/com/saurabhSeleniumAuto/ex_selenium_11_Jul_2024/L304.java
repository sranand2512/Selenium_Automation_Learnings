package com.saurabhSeleniumAuto.ex_selenium_11_Jul_2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class L304 {
        public static void main(String [] args) throws InterruptedException {
            WebDriver driver = new EdgeDriver();
            driver.get("https://facebook.com");
            driver.manage().window().maximize();

            // here No back, forward is allowed

            driver.navigate().to("https://www.google.com");
            driver.navigate().to("https://www.bing.com");
            driver.navigate().back();
            driver.navigate().back();
            driver.navigate().forward();
            driver.navigate().refresh();

            driver.quit();


            // navigate().to() and get() will do the same thing
        }
}
