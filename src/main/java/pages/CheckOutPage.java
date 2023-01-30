package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {
    private final WebDriver driver;
    public CheckOutPage(WebDriver driver){
        this.driver = driver;
    }
    // first step
    private final By proceedCheckOutBtn = By.xpath("//a[text()='Proceed To Checkout']");

    public void navigateToProceedCheckOut() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(proceedCheckOutBtn).click();
    }
    private final By placeOrderBtn = By.xpath("//a[text()='Place Order']");

    public void navigateToPaymentMethode() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(placeOrderBtn)));
        driver.findElement(placeOrderBtn).click();
    }


    private final By nameOfCard = By.xpath("//input[@name='name_on_card']");
    private final By cardNumber = By.xpath("//input[@name='card_number']");
    private final By cvcNumber = By.xpath("//input[@name='cvc']");
    private final By expiryMonth = By.xpath("//input[@name='expiry_month']");
    private final By expiryYear = By.xpath("//input[@name='expiry_year']");
    private final By submitOrder = By.id("submit");
    private final By assertionMessage = By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");

    public void completeProceedCheckOut(String name, String CNumber, String cvc, String month, String year) {
        driver.findElement(nameOfCard).sendKeys(name);
        driver.findElement(cardNumber).sendKeys(CNumber);
        driver.findElement(cvcNumber).sendKeys(cvc);
        driver.findElement(expiryMonth).sendKeys(month);
        driver.findElement(expiryYear).sendKeys(year);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(submitOrder).click();
    }

    public String proceedAssertion() {
        return driver.findElement(assertionMessage).getText();
    }



}
