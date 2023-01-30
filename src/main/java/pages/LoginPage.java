package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    private final By emailTxt = By.xpath("//input[@placeholder='Email Address' and @data-qa='login-email']");
    private final By passwordTxt = By.xpath("//input[@data-qa='login-password']");
    private final By logBtn = By.xpath("//button[@data-qa='login-button']");

    public void Login(String email, String password) {
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(logBtn).click();
    }
}
