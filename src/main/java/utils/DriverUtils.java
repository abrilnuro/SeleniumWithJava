package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtils {

    public WebDriver driver;

    public DriverUtils(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        this.driver = new ChromeDriver(options);
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public void openBrowser(String url){
        this.driver.get(url);
    }
}