package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ContactUsPage {
    private final WebDriver driver;
    Alert alert;
    public ContactUsPage(WebDriver driver){
        this.driver = driver;
    }
    private final By contactUsPageAssertion = By.xpath("//h2[text()='Get In Touch']");

    public String assertThatUserIContactUsPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(contactUsPageAssertion).getText();
    }

    private final By nameTxt = By.xpath("//input[@name='name']");
    private final By emailTxt = By.xpath("//input[@name='email']");
    private final By subjectTxt = By.xpath("//input[@name='subject']");
    private final By messageTxt = By.id("message");
    private final By uploadFile = By.name("upload_file");
    private final By submitBtn = By.xpath("//input[@name='submit']");
    private final By contactAssertionMessage = By.xpath("//div[@class='status alert alert-success']");

    public void ContactUs(String name, String email, String subject, String message, String file) {
        driver.findElement(nameTxt).sendKeys(name);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(subjectTxt).sendKeys(subject);
        driver.findElement(messageTxt).sendKeys(message);
        driver.findElement(uploadFile).sendKeys(file);
        driver.findElement(submitBtn).click();
        alert = driver.switchTo().alert();
        alert.accept();

    }

    public String getContactAssertionMessage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(contactAssertionMessage).getText();
    }

}
