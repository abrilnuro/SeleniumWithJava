import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WikipediaPage {

    //se comunica con el DOM de la app.
    WebDriver driver;

    //locators
    By searchInput = By.id("searchInput");
    By searchButton = By.name("search");
    By searchResult = By.id("firstHeading");
    By getSearchInputXpath = By.xpath("/html[@class='js-enabled']/body[@id='www-wikipedia-org']/div[@class='search" +
            "-container']/form[@id='search-form']/fieldset/div[@id='search-input" +
            "']/input[@id='searchInput']");

    public WikipediaPage() {
        this.driver = driver;
    }

    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    public void openChrome() {
        driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
    }

    public void closeChromePage() {
        driver.close();
    }

    public void sendKeysToSearch() {
        // Explicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement element = driver.findElement(searchButton);
        element.sendKeys("java");
    }

    public void search() {
        driver.findElement(searchButton).submit();
    }

    public String getSearchResultText() {
        //Explicit  wait
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Implicit wait
        //WebElement search_result = new WebDriverWait(driver, 2).until(driver -> driver.findElement(searchResult));

        WebElement search = driver.findElement(searchResult);
        return search.getText();
    }

}

