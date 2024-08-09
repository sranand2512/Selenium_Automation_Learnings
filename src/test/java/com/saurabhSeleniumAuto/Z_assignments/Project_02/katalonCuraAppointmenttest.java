package com.saurabhSeleniumAuto.Z_assignments.Project_02;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class katalonCuraAppointmenttest {


    @Test
    @Description("TC1, to verify the make appointment text")
    public static void testMakeAppointmentButton(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        //options.addArguments("--start-maximized");
        options.addArguments("window-size=500,700");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        EdgeDriver driver = new EdgeDriver(options);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");


        WebElement makeAppointmentBtn = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentBtn.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");

        driver.quit();

    }

    @Test
    @Description("TC2, Verify the login in app with valid credential and verify the make oppointment text on page")
    public static void testLoginforMakingAppointment(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        //options.addArguments("--start-maximized");
        options.addArguments("window-size=500,700");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        EdgeDriver driver = new EdgeDriver(options);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");
//        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");


        WebElement makeAppointmentBtn = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentBtn.click();

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");


        WebElement U_username = driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Username' and @aria-describedby='demo_username_label']"));
        String Username = U_username.getAttribute("value");

        WebElement P_password = driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Password' and @aria-describedby='demo_password_label']"));
        String Password =P_password.getAttribute("value");


        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys(Username);

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys(Password);

        WebElement signBtn = driver.findElement(By.id("btn-login"));
        signBtn.click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

        WebElement heading = driver.findElement(By.xpath("//div[@class='col-sm-12 text-center']//h2[text()='Make Appointment']"));
        String headinText = heading.getText();
        Assert.assertEquals("Make Appointment", headinText);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

    @Test
    @Description("TC3, Verify that making of appoint can we done")
    public static void testmakeAppointment(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--guest");
        //options.addArguments("--start-maximized");
        options.addArguments("window-size=500,700");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        EdgeDriver driver = new EdgeDriver(options);
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");
//        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");


        WebElement makeAppointmentBtn = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentBtn.click();

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");


        WebElement U_username = driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Username' and @aria-describedby='demo_username_label']"));
        String Username = U_username.getAttribute("value");

        WebElement P_password = driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Password' and @aria-describedby='demo_password_label']"));
        String Password =P_password.getAttribute("value");


        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys(Username);

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys(Password);

        WebElement signBtn = driver.findElement(By.id("btn-login"));
        signBtn.click();


//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

//        WebElement heading = driver.findElement(By.xpath("//div[@class='col-sm-12 text-center']//h2[text()='Make Appointment']"));
//        String headingText = heading.getText();
//        Assert.assertEquals("Make Appointment", headingText);


//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        WebElement facility_dropdown = driver.findElement(By.id("combo_facility"));
        Select select_facility = new Select(facility_dropdown);
        select_facility.selectByIndex(1);

        WebElement chk_hospotal_readmission = driver.findElement(By.id("chk_hospotal_readmission"));
        chk_hospotal_readmission.click();

        WebElement radio_program_medicaid = driver.findElement(By.id("radio_program_medicaid"));
        radio_program_medicaid.click();

        WebElement txt_visit_date = driver.findElement(By.id("txt_visit_date"));
        txt_visit_date.sendKeys("30/08/2024");

        WebElement txt_comment = driver.findElement(By.id("txt_comment"));
       txt_comment.sendKeys("Want a booking on 30/08/2024");

        WebElement btn_book_appointment = driver.findElement(By.id("btn-book-appointment"));
        btn_book_appointment.click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement confirmationHeading = driver.findElement(By.xpath("//h2[text()='Appointment Confirmation']"));
        String headingText = confirmationHeading.getText();
        Assert.assertEquals("Appointment Confirmation", headingText);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

       driver.quit();



    }



}
