package com.saurabhSeleniumAuto.ex_selenium_11_Jul_2024;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class L298 {

    // Flow of selenium
    @Test
    public void vwoLogin(){
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://facebook.com");
        driver.manage().window().maximize();
        driver.quit();

        // Flow of selenium
        // 1. Session is created with ID like - fb6876467f874rt6ty
        // Client is - Java programs
        // Server is Web driver edge-command W#C - edge browser
        // 2. Session run on the command Get-get method
        // 3. Edge driver(server) ask to run the bew browser ie edge.
        // 4. Open a fresh copy of the edge browser and open the given url
        // 5. Driver - command to quit the browser. and session id will be null
    }
}
