import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class StarbucksRewardsPage extends AbstractPageObject {

    //@FindBy(xpath = "/html/body/div[1]/div/header/div/div/nav/ul/li[1]/a")
    //@CacheLookup
    private By rewardsTab = By.xpath("/html/body/div[1]/div/header/div/div/nav/ul/li[5]/a");

    public StarbucksRewardsPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void selectRewardTab(){
        System.out.println("Entro");
        String n = webDriver.findElement(By.className("router-link-exact-active router-link-active")).getText();
        webDriver.findElement(this.rewardsTab).click();
    }
}
