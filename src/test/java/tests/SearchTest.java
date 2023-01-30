package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

import java.time.Duration;

public class SearchTest extends TestBase{

    HomePage home;
    ProductsPage product;

    @Test
    public void navigateToProductsPage(){
        home = new HomePage(driver);
        home.navigateToProductPage();
        product = new ProductsPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(product.getAssertionMessage(),"ALL PRODUCTS");
    }

    @Test(priority = 1)
    public void searchForProducts(){
        product = new ProductsPage(driver);
        product.searchForProducts("polo");
        Assert.assertEquals(product.getSearchAssertionMessage(),"SEARCHED PRODUCTS");
    }
}
