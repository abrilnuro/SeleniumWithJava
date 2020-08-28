import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchStarbucksCoffeeTest extends BaseTest{

    private StarbucksCoffeePage starbucksCoffeePage;

    public LaunchStarbucksCoffeeTest(){ }

    @Test(description = "click on all tabs", groups = "regression")
    public void validateChromePage(){
        this.starbucksCoffeePage = new StarbucksCoffeePage(driverUtils.getDriver());
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
}
