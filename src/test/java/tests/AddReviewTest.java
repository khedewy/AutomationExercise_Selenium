package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetails;
import pages.ProductsPage;

import java.time.Duration;

public class AddReviewTest extends TestBase{
    HomePage home;
    ProductsPage product;
    ProductDetails details;

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
        product.navigateToProductDetails();
    }

    @Test(priority = 2)
    public void addReviewToProducts(){
        details = new ProductDetails(driver);
        details.addReview("mahmoud","khedewy543@gmail.com","this a very good product");
        Assert.assertEquals(details.getReviewAssertionMessage(),"Thank you for your review.");
    }
}
