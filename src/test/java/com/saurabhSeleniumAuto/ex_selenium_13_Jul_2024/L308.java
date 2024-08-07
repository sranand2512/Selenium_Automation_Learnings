package com.saurabhSeleniumAuto.ex_selenium_13_Jul_2024;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class L308 {
    public static void main(String[] args) throws InterruptedException {
        EdgeOptions options = new EdgeOptions();
        // Browser - headless(No UI) and full mode
        // 1. Headless - No UI, performance will be good and fast due to no UI, used in if we are running more number of TC
        // 2. Full mode - UI will be visible, performance will be high, used in if we are running single TC

        // Options- Browser - start maximise, add extension, add option as argument

          options.addArguments("--headless");
          options.addArguments("--start-maximized");
          options.addArguments("--start-minimised");
          options.addArguments("--window -size =800,600");
          options.addArguments("--guest");


//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy("200.115.188.52:8080");
//        options.setCapability("proxy", proxy);




        WebDriver driver = new EdgeDriver(options);
        driver.get("https://www.google.com");
       // driver.manage().window().maximize();
        Thread.sleep(3000);
      //  driver.manage().window().minimize();
        driver.quit();


    }
}
