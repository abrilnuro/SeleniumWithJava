import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class StarbucksCoffeePage extends AbstractPageObject {

    private By coffeeTab = By.xpath("/html/body/header/div/div/div/div/nav/div[2]/ul/li[1]/a/strong");

    private By coffeeCategory = By.xpath("/html/body/div[2]/ol/li[1]/div[1]/ol/li[1]/ol/li[1]/a");

    private By coffeeFilter;

    private By coffeeList = By.className("coffeeItem");

    private By learnMore = By.xpath("/html/body/main/div/div/div[2]/section[2]/div/div/div/div[3]/div[5]/div[2]/span/a");

    private By description = By.className("coffeeDetails");

    public StarbucksCoffeePage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void clickTabs(){
        webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        List<WebElement> elements = webDriver.findElements(By.className("tab"));
        elements.stream().filter(item -> item.isDisplayed()).forEach(webElement -> webElement.click());
    }

    public void selectCoffeeTab(){
        webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        WebElement element = webDriver.findElement(coffeeTab);
        element.click();
    }

    public void selectCoffeeCategory(){
        //driver.navigate().refresh();
        webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        WebElement category = webDriver.findElement(this.coffeeCategory);
        category.click();
    }

    public void checkBoxCoffee(){
        //scroll
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy({top: 300, behaviour: 'smooth'})");

        for (int i=1; i<6; i++) {
            if(i != 2) {
                coffeeFilter = By.xpath("/html/body/main/div/div/div[2]/section[1]/div/div/div/ul/li[" + i + "]/ul/li");
                webDriver.findElement(coffeeFilter).click();
            }
        }
    }

    public boolean getResultList(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy({top: 600, behaviour: 'smooth'})");

        List<WebElement> elements = webDriver.findElements(this.coffeeList);
        return elements.size() == 14;
    }

    public boolean findCoffeeInList(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy({top: 600, behaviour: 'smooth'})");

        List<WebElement> elements = webDriver.findElements(this.coffeeList);
        Optional<WebElement> optionalElement = elements.stream()
                .filter(item -> item.findElement(By.tagName("h5")).getText().equals("Mexico Chiapas"))
                .findFirst();

        return optionalElement.isPresent();
    }

    public boolean validateDescription(){
        WebElement learnMoreElement = webDriver.findElement(this.learnMore);
        learnMoreElement.click();

        Optional<String> optionalDescription = Optional.ofNullable(webDriver.findElement(this.description).getText());

        return optionalDescription.isPresent();
    }

}
