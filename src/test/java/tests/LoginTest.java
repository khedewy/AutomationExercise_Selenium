package tests;

import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.io.IOException;

public class LoginTest extends TestBase{
    HomePage home;
    RegisterPage register;
    LoginPage log;
    @Test
    public void navigateToSignUpPage(){
        home = new HomePage(driver);
        register = new RegisterPage(driver);
        home.navigateToRegisterPage();
        Assert.assertEquals(register.getAssertionMessage(),"New User Signup!");
    }

    @Test(priority = 1)
    public void EnterUserData() throws IOException, ParseException {
        RegisterData data = new RegisterData(driver);
        data.UserData();
        register = new RegisterPage(driver);
        register.FirstStepDataOfRegister(data.email,data.name);
        register.completeRegisterData(data.password, data.day,
                data.month, data.year, data.firstName, data.lastName, data.company,
                data.address1, data.address2, data.country, data.state, data.city,
                data.zipcode, data.mobNumber);

        Assert.assertEquals(register.getCreateAccountAssertionMessage(),"ACCOUNT CREATED!");
        register.clickContinue();
        home = new HomePage(driver);
        Assert.assertEquals(home.logOutAssertion()," Logout");
    }

    @Test(priority = 2)
    public void logOut(){
        home = new HomePage(driver);
        home.logOut();
        home.navigateToLoginPage();
    }

    @Test(priority = 3)
    public void login() throws IOException, ParseException {
        RegisterData data = new RegisterData(driver);
        data.UserData();
        log = new LoginPage(driver);
        log.Login(data.email, data.password);
        home = new HomePage(driver);
        Assert.assertEquals(home.logOutAssertion(),"Logout");
    }

}
