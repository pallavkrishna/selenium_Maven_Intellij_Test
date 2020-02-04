package practice.testng.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinksInPage {
    WebDriver driver =null;
    WebElement element=null;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
         driver.manage().window().maximize();
    }
    @Test
    public void verifyLinksInPage(){
        driver.get("https:\\www.google.com");
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        List<WebElement> webElements =  driver.findElements(By.tagName("a"));
        for (int i =0;i<webElements.size()-1;i++){
            System.out.println(webElements.get(i).getText());

        }
    }
    @AfterMethod
    public void tearDow(){
        driver.close();
        driver.quit();
    }
}
