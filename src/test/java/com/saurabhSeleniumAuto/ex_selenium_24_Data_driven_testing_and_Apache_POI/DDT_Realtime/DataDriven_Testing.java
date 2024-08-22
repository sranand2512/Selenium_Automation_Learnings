package com.saurabhSeleniumAuto.ex_selenium_24_Data_driven_testing_and_Apache_POI.DDT_Realtime;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class DataDriven_Testing {

   // EdgeDriver driver;
   WebDriver driver;

    @BeforeClass
    // public void setup()
    public void openBrowser() {
//        EdgeOptions options = new EdgeOptions();
//        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        options.addArguments("--guest");
//        options.addArguments("--start-maximized");
        driver = new EdgeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    @Test(dataProvider = "loginData")
    @Description("Test Case for Login details fetch from excel / Data Driven testing ")
    public void testDataDriven(String email, String password, String expectedResult) {
        String URL = "https://app.vwo.com/";
        driver.get(URL);


        WebElement emailInputField = driver.findElement(By.id("login-username"));
        emailInputField.clear();
        emailInputField.sendKeys(email);

        WebElement passwordInputField = driver.findElement(By.id("login-password"));
        passwordInputField.clear();
        passwordInputField.sendKeys(password);

        driver.findElement(By.id("js-login-btn")).click();



        if (expectedResult.equalsIgnoreCase("Valid")){
            String text = driver.findElement(By.xpath("//*[@data-qa=\"lufexuloga\"]")).getText();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.titleIs("Dashboard"));
            System.out.println(text);
            Assert.assertEquals(text,"test one");

            driver.findElement(By.xpath("//*[@data-qa=\"user-image\"]")).click();
            driver.findElement(By.xpath("//*[@data-qa=\"logout-btn\"]")).click();
        }
        if(expectedResult.equalsIgnoreCase("InValid")){
            WebElement error_msg = driver.findElement(By.id("js-notification-box-msg"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(error_msg));
            Assert.assertTrue(error_msg.isDisplayed());
            Assert.assertEquals(error_msg.getText(),"Your email, password, IP address or location did not match");

        }


    }

      @DataProvider(name = "loginData")
      public String [][] testExcelData() throws IOException {
        String testfileLocation = "src/test/resources/login1.xlsx";
        ExcelReader excelReader = new ExcelReader(testfileLocation);
        String [][] data = excelReader.getDataFromSheet(testfileLocation,"abc1");
        return data;
      }



//    @DataProvider(name = "loginData")
//    public Object[][] testData(){
//        return new Object[][]{
//                {"TD2", "abc@morxin.com", "Test123456756", "InValid"},
//                {"TD1", "fiviwof416@morxin.com", "Test1234567", "Valid"},
//        };
//    }

    @AfterClass
    // public void tearDown
    public void closeBrowser() {
        driver.quit();
    }

}



