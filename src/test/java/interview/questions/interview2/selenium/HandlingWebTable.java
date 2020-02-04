package interview.questions.interview2.selenium;

import Helper.testng.examples.TestBase;
import interview.questions.TestSuiteBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HandlingWebTable extends TestSuiteBase {
    WebElement element=null;
    @Test
    public void test() {

        driver.get("http://demo.automationtesting.in/WebTable.html");
        int size = driver.findElements(By.cssSelector("[class='ui-grid-row ng-scope']")).size();
        int index=1;

        for ( int i =1; i < size; i++) {
            String cssSelector="div [class='ui-grid-canvas']> div:nth-child("+i+") > div >div[class='ui-grid-cell ng-scope ui-grid-coluiGrid-000";
            System.out.print(

                    "First Name-> "+ driver.findElement(By.cssSelector(cssSelector+(index+5)+"']")).getText() +
                    " LastName-> "+driver.findElement(By.cssSelector(cssSelector+(index+7)+"']")).getText() +
                    " Gender-> "+driver.findElement(By.cssSelector(cssSelector+(index+6)+"']")).getText()+
                    " Phone-> "+driver.findElement(By.cssSelector(cssSelector+(index+8)+"']")).getText() +
                    " Email-> "+driver.findElement(By.cssSelector(cssSelector+(index+4)+"']")).getText()+"\n"

                );

           // System.out.print();


        }
    }


}
