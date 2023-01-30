package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SubscribeTest extends TestBase{
    HomePage home;

    @Test
    public void subscribeTest(){
        home = new HomePage(driver);
        home.userCanSubscribe("Mahmoud00@gmail.com");
        Assert.assertEquals(home.getSubscribeAssertionMessage(),"SUBSCRIPTION");
    }
}
