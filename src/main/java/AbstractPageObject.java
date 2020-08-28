import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageObject {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public AbstractPageObject(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 30);
    }
}
