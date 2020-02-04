package interview.questions.interview2.selenium;

import interview.questions.TestSuiteBase;
import org.testng.annotations.Test;

public class LaunchBrowser extends TestSuiteBase {

    @Test
    public void test(){
        driver.get("https:\\www.google.com");
        System.out.println(driver.getTitle());
    }

}
