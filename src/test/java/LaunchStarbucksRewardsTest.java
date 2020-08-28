import org.testng.annotations.Test;

public class LaunchStarbucksRewardsTest extends BaseTest {

    private StarbucksRewardsPage starbucksRewardsPage;

    public LaunchStarbucksRewardsTest(){ }

    @Test(description = "rewards", groups = "regression")
    public void selectRewards(){
        this.starbucksRewardsPage = new StarbucksRewardsPage(driverUtils.getDriver());
        this.starbucksRewardsPage.selectRewardTab();
    }

}
