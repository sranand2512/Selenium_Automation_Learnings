package com.saurabhSeleniumAuto.ex_selenium_11_Jul_2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class L302 {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        //WebDriver driver = new WebDriver(); // interface we can not create the instance of it

        driver.get("https://facebook.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
        driver.quit();
	}

}
