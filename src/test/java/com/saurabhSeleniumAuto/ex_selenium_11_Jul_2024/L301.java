package com.saurabhSeleniumAuto.ex_selenium_11_Jul_2024;

import org.openqa.selenium.chrome.ChromeDriver;

public class L301 {
    public static void main(String[] args) {

//        ChromeDriver driver = new ChromeDriver();
//        // Selenium 3.0
//        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        // JSON wire protocol
//        driver.get("https://sdet.live");


        // Selenium 4.0
        // Selenium manager - W3C protocol
        // opera Removed - :)
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://sdet.live");
        driver.quit();

    }

}
