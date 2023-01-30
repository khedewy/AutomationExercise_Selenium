package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    private final By signUpBtn = By.xpath("//a[text()=' Signup / Login']");

    public RegisterPage navigateToRegisterPage() {
        driver.findElement(signUpBtn).click();
        return new RegisterPage(driver);
    }

    private final By productsButton = By.xpath("//a[text()=' Products']");

    public ProductsPage navigateToProductPage() {
        driver.findElement(productsButton).click();
        return new ProductsPage(driver);
    }

    private final By contactUBtn = By.xpath("//a[text()=' Contact us']");

    public ContactUsPage navigateToContactUsPage() {
        driver.findElement(contactUBtn).click();
        return new ContactUsPage(driver);
    }

    private final By logOutBtn = By.xpath("//a[text()=' Logout']");
    private final By loginBtn = By.xpath("//a[text()=' Signup / Login']");

    public void logOut() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(logOutBtn).click();
    }

    public LoginPage navigateToLoginPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(loginBtn).click();
        return new LoginPage(driver);
    }

    public String logOutAssertion() {
        return driver.findElement(logOutBtn).getText();
    }

    private final By emailTxt = By.id("susbscribe_email");
    private final By submitBtn = By.id("subscribe");
    private final By subscribeAssertion = By.xpath("//h2[text()='Subscription']");

    public void userCanSubscribe(String email) {
        driver.findElement(emailTxt).sendKeys(email);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(submitBtn).click();
    }

    public String getSubscribeAssertionMessage() {
        return driver.findElement(subscribeAssertion).getText();
    }
}
