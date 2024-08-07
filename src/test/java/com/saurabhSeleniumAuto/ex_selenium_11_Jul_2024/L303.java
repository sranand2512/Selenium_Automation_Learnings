package com.saurabhSeleniumAuto.ex_selenium_11_Jul_2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class L303 {
    public static void main(String [] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://facebook.com");
        driver.manage().window().maximize();
        Thread.sleep(Long.parseLong("3000"));


      //  Difference between quit and close

        driver.quit(); // close all the browser windows and session will be Null means complete shutdown
       // driver.close();// only close the current tab session will not Null

    }

}
