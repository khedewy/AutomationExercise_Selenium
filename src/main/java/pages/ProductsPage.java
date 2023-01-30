package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    private final WebDriver driver;
    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    // assert that user in the product page
    private final By allProductAssertion = By.xpath("//h2[text()='All Products']");

    public String getAssertionMessage() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(allProductAssertion)));
        return driver.findElement(allProductAssertion).getText();
    }
    private final By searchBox = By.id("search_product");
    private final By submitSearch = By.id("submit_search");
    private final By searchAssertion = By.xpath("//h2[text()='Searched Products']");
    private final By viewProducts = By.xpath("//a[text()='View Product']");


    public void searchForProducts(String product) {
        driver.findElement(searchBox).sendKeys(product);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(submitSearch)));
        driver.findElement(submitSearch).click();
    }

    public String getSearchAssertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchAssertion)));
        return driver.findElement(searchAssertion).getText();
    }

    public ProductDetails navigateToProductDetails(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(viewProducts).click();
        return new ProductDetails(driver);
    }

}
