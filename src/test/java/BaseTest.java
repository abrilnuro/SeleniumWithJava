import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.DriverUtils;

public class BaseTest {

    protected static final String URL = "https://www.starbucks.com.mx/";
    protected static DriverUtils driverUtils;

    @BeforeSuite
    public static void setupWebDriver() {
        driverUtils = new DriverUtils();
        driverUtils.openBrowser(URL);
    }

    @AfterSuite
    public void deleteAllCookies() {
        driverUtils.getDriver().manage().deleteAllCookies();
    }
}
