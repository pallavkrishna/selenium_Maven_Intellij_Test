package interview.questions;

import Helper.testng.examples.TestBase;
import org.testng.annotations.BeforeMethod;

public class TestSuiteBase extends TestBase {

    @BeforeMethod
    public void $setUp(){
        setUp();
    }
    public void $tearDown(){
        tearDown();
    }
}
