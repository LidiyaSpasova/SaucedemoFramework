package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil extends DataProviders {
    public WebDriver driver;
    private String testUrl, browser;
    private int implicitWait;


    @BeforeMethod
    public void driverSetupAndOpenTestAddress(){
        readConfiguration("src/test/resources/config.properties");
        setupDriver();
        driver.get(testUrl);
    }

    private void readConfiguration(String fullPathToConfigFile){
        try{
            FileInputStream fileInputStream = new FileInputStream(fullPathToConfigFile);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            testUrl = properties.getProperty("URL");
            browser = properties.getProperty("browser");
            implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));

        }catch (IOException e){
            System.out.println(e);
        }
    }
    private void setupDriver(){
        switch (browser){
            case "firefox":
                driver = setupFirefoxDriver();
                break;
            default:
                driver = setupChromeDriver();
        }
    }
    private WebDriver setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
    private WebDriver setupFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}



