import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.DriverUtils;

public class LaunchStarbucksTestOriginal {

    private DriverUtils driverUtils;
    private StarbucksCoffeePage starbucksCoffeePage;
    private StarbucksRewardsPage starbucksRewardsPage;

    @BeforeSuite
    public void setup(){ }

    @Test(description = "click on all tabs", groups = "regression")
    public void validateChromePage(){
        this.driverUtils = new DriverUtils();
        this.starbucksCoffeePage = new StarbucksCoffeePage(driverUtils.getDriver());
        this.starbucksRewardsPage = new StarbucksRewardsPage(driverUtils.getDriver());
        driverUtils.openBrowser("");

        this.starbucksCoffeePage.clickTabs();
    }

    @Test(description = "select coffee", groups = "regression")
    public void validateCoffeeSelection(){
        this.starbucksCoffeePage.selectCoffeeTab();
        this.starbucksCoffeePage.selectCoffeeCategory();
        this.starbucksCoffeePage.checkBoxCoffee();

        Assert.assertTrue(this.starbucksCoffeePage.getResultList(), "You should get 14 results");
        Assert.assertTrue(this.starbucksCoffeePage.findCoffeeInList(), "Mexico Chiapas coffee was not found");
        Assert.assertTrue(this.starbucksCoffeePage.validateDescription(), "Description is null");
    }

    @Test(description = "rewards", groups = "regression")
    public void validateStarbucksRewards(){
       // this.starbucksRewardsPage = new StarbucksRewardsPage(driverUtils.getDriver());
       //this.starbucksRewardsPage.selectRewardTab();
    }

    @AfterSuite
    public void quit(){
        driverUtils.getDriver().close();
    }
}
