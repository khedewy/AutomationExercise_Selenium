package tests;

import data.CheckOutData;
import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.time.Duration;

public class CheckOutTest extends TestBase{
    HomePage home;
    ProductsPage product;
    ProductDetails details;
    CheckOutPage check;
    LoginPage log;

    @Test
    public void login() throws IOException, ParseException {
        home = new HomePage(driver);
        home.navigateToLoginPage();
        RegisterData data = new RegisterData(driver);
        data.UserData();
        log = new LoginPage(driver);
        log.Login(data.email, data.password);
        Assert.assertEquals(home.logOutAssertion(),"Logout");
    }
    @Test(priority = 1)
    public void navigateToProductsPage(){
        home = new HomePage(driver);
        home.navigateToProductPage();
        product = new ProductsPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(product.getAssertionMessage(),"ALL PRODUCTS");
    }

    @Test(priority = 2)
    public void searchForProducts(){
        product = new ProductsPage(driver);
        product.searchForProducts("polo");
        Assert.assertEquals(product.getSearchAssertionMessage(),"SEARCHED PRODUCTS");
        product.navigateToProductDetails();
    }

    @Test(priority = 3)
    public void addToCart(){
        details = new ProductDetails(driver);
        details.addFirstProductToCart();
        Assert.assertEquals(details.getAssertionMessage(),"Premium Polo T-Shirts");
    }
    @Test(priority = 4)
    public void proceedCheckOut() throws IOException, ParseException {
        CheckOutData data = new CheckOutData(driver);
        data.checkOutData();
        check = new CheckOutPage(driver);
        check.navigateToProceedCheckOut();
        check.navigateToPaymentMethode();
        check.completeProceedCheckOut(data.name, data.cardNumber, data.cvc, data.month, data.year);
        Assert.assertEquals(check.proceedAssertion(),"Congratulations! Your order has been confirmed!");
    }
}
