package practice.testng.Selenium;

import Helper.testng.examples.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class IntellijSmokeTest {
    TestBase testBase=null;
    @BeforeTest
    public void beforeTest() throws IOException {
        testBase=new TestBase();
        System.out.println("BeforeTest");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest");
    }
    @Test
    public void test() throws Exception{
        WebDriver driver=null;
        System.out.println("Test");
        driver=testBase.openParallelBrowser("chrome");
        driver.get("https://business.spectrum.com/phone.html");
        /*validateshowNowCTA("[data-linkname='view_deals']",driver);
        validateshowNowCTA("[data-linkname='shop_for_phone_keep_connected']",driver);
        validateshowNowCTA("[data-linkname='shop_for_phone_features_section']",driver);
        validateshowNowCTA("[data-linkname='shop_for_service']",driver);
        validateshowNowCTA("[data-linkname='shop_for_phone_services_section']",driver);*/
        validateshowNowCTA("[data-linkname='shop_for_phone_services_section']",driver);

        testBase.closeParallelBrowser(driver);

    }


    public void validateshowNowCTA(String identifier,WebDriver driver) throws InterruptedException {
        System.out.println(driver.getCurrentUrl());
        WebElement element=driver.findElement(By.cssSelector(identifier));
        element.sendKeys(Keys.chord(Keys.CONTROL+"n"));

        Thread.sleep(5000);
        /*System.out.println(element.getText());*/
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        //driver.get("https://business.spectrum.com/phone.html");
    }
}
