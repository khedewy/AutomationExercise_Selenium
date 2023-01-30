package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProductDetails {
    private final WebDriver driver;
    public ProductDetails(WebDriver driver){
        this.driver = driver;
    }

    // Add Product to cart
    private final By addToCartBtn = By.xpath("//button[@class='btn btn-default cart']");
    private final By viewCart = By.linkText("View Cart");
    private final By addToCartAssertion = By.xpath("//a[text()='Premium Polo T-Shirts']");

    public void addFirstProductToCart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(addToCartBtn).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(viewCart).click();
    }

    public String getAssertionMessage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(addToCartAssertion).getText();
    }

    private final By nameTxt = By.id("name");
    private final By emailTxt = By.id("email");
    private final By messageTxt = By.id("review");
    private final By submitReview = By.id("button-review");
    private final By reviewAssertion = By.id("review-section");

    public void addReview(String name, String email, String message) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(nameTxt).sendKeys(name);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(messageTxt).sendKeys(message);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(submitReview).click();
    }

    public String getReviewAssertionMessage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(reviewAssertion).getText();
    }

}
