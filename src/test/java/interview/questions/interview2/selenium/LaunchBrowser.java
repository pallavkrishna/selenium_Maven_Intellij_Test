package practice.interview.questions.interview2.selenium;

import Helper.testng.examples.TestBase;
import org.testng.annotations.Test;
import practice.interview.questions.TestSuiteBase;

public class LaunchBrowser extends TestSuiteBase {

    @Test
    public void test(){
        driver.get("https:\\www.google.com");
        System.out.println(driver.getTitle());
    }

}
