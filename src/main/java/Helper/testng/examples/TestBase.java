package Helper.testng.examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.util.Properties;

public class TestBase {

    public WebDriver driver = null;
    private DesiredCapabilities desiredCapabilities = null;
    private ChromeOptions chromeOptions = null;
    private FirefoxOptions firefoxOptions = null;
    private FirefoxProfile firefoxProfile = null;
    private Properties properties = null;
    private InputStream inputStream = null;
    private File file = null;
    private String path = null;
    private String browserName = null;
    private String browserType = null;

    public TestBase() {
        try {
            loadConfig();
            //load();
            browserName = properties.getProperty("browserName");
            browserType = properties.getProperty("browserType");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadConfig() throws IOException {
        path = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
        System.out.println(path);
        properties = new Properties();
        properties.load(new FileInputStream(new File(path)));

    }

    public void load() {
        path = System.getProperty("usr.dir") + "\\src\\main\\resources\\config.properties";
        properties = new Properties();
        try {
            InputStream io = new FileInputStream(path);
            properties.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebDriver openParallelBrowser(String browserName) {
        WebDriver driver = null;
        if (StringUtils.containsIgnoreCase(browserName, "chrome")) {
            WebDriverManager.chromedriver().setup();
            desiredCapabilities = new DesiredCapabilities();

            if (StringUtils.containsIgnoreCase(browserName, "headless")) {
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");

            }
            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-agent=dmqa-testing");


            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(desiredCapabilities);
            driver.manage().window().maximize();

        }

        return driver;


    }

    public void setUp() {
        System.out.println("browserType : " + browserType + "browserName :" + browserName);
        if (browserName.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            if (browserType.contains("headless")) {
                chromeOptions=new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
            } else {
                driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
        }
        if (browserName.contains("firefox")) {
            WebDriverManager.chromedriver().setup();
            if (browserType.contains("headless")) {
                chromeOptions.addArguments(browserType);
                driver = new ChromeDriver(chromeOptions);
            } else {
                driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
        }


    }

    public void tearDown() {
        driver.close();
        driver.quit();
    }

    public void closeParallelBrowser(WebDriver driver) {
        driver.close();
        driver.quit();
    }


}
