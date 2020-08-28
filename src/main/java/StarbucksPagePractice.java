import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StarbucksPagePractice {

    private WebDriver webDriver;
    private By cafeTab = By.xpath("/html/body/header/div/div/div/div/nav/div[2]/ul/li[1]/a/strong");
    private By menuTab = By.xpath("/html/body/header/div/div/div/div/nav/div[2]/ul/li[2]/a/strong");

    public StarbucksPagePractice(){
        this.webDriver = webDriver;
    }

    public void setWebDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    public void openChrome(){
        webDriver = new ChromeDriver();
        webDriver.get("https://www.starbucks.com.mx/");
    }

    public void clickTab(){
        webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        WebElement element = webDriver.findElement(cafeTab);
        element.click();

        webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        WebElement element2 = webDriver.findElement(menuTab);
        element2.click();
    }

    public void iterateTabList(){
        this.webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        List<WebElement> elements = this.webDriver.findElements(By.className("tab"));
        java.util.Iterator<WebElement> i = elements.iterator();
        while(i.hasNext()) {
            WebElement element = i.next();
            if (element.isDisplayed()) {
                element.click();
                System.out.println(element.getText());
            }
        }
    }

    public void clickTabs2(){
        this.webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        //Actions actions = new Actions(webDriver);
        List<WebElement> elements = this.webDriver.findElements(By.className("tab"));
        elements.stream().filter(item -> item.isDisplayed()).forEach(webElement -> webElement.click());
    }

    public void clickTabs(){
        this.webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        Actions actions = new Actions(webDriver);
        List<WebElement> elements = this.webDriver.findElements(By.className("tab"));
        for (WebElement e : elements) {
            System.out.println(e.getText());
            if(e.isDisplayed()) {
                actions.click(e).build().perform();
            }
            WebElement nextButton = webDriver.findElement(By.id("nav_1"));
            if (nextButton.isEnabled()) {
                actions.moveToElement(nextButton).click().perform();
            }
        }
    }
}
