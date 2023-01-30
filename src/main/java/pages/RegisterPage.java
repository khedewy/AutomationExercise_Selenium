package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    Select select;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    // register first step locators
    private final By nameTxt = By.xpath("//input[@data-qa='signup-name']");
    private final By emailTxt = By.xpath("//input[@data-qa='signup-email']");
    private final By signUpButton = By.xpath("//button[@data-qa='signup-button']");
    private final By assertionMessage = By.xpath("//h2[text()='New User Signup!']");

    public String getAssertionMessage() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertionMessage)));
        return driver.findElement(assertionMessage).getText();
    }

    public void FirstStepDataOfRegister(String email, String name){
        driver.findElement(nameTxt).sendKeys(name);
        driver.findElement(emailTxt).sendKeys(email);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(signUpButton)));
        driver.findElement(signUpButton).click();

    }

    // second step locators

    private final By genderBtn = By.id("id_gender1");
    private final By passwordTxt = By.id("password");

    private final By days = By.id("days");
    private final By months = By.id("months");
    private final By years = By.id("years");
    private final By firstNameTxt = By.id("first_name");
    private final By lastNameTxt = By.id("last_name");
    private final By companyTxt = By.id("company");
    private final By address1Txt = By.id("address1");
    private final By address2Txt = By.id("address2");
    private final By countries = By.id("country");
    private final By stateTxt = By.id("state");
    private final By cityTxt = By.id("city");
    private final By zipCodeTxt = By.id("zipcode");
    private final By mobileNumber = By.id("mobile_number");
    private final By createAccountBtn = By.xpath("//button[@data-qa='create-account']");
    private final By createAccountAssertion = By.xpath("//b[text()='Account Created!']");
    private final By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    public void completeRegisterData(String password, String day, String month, String year, String firstName, String lastName,
                                     String company, String address1, String address2, String country, String state,
                                     String city, String zipcode, String mobileNim) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(genderBtn)));
        driver.findElement(genderBtn).click();
        driver.findElement(passwordTxt).sendKeys(password);
        select = new Select(driver.findElement(days));
        select.selectByVisibleText(day);
        select = new Select(driver.findElement(months));
        select.selectByVisibleText(month);
        select = new Select(driver.findElement(years));
        select.selectByVisibleText(year);
        driver.findElement(firstNameTxt).sendKeys(firstName);
        driver.findElement(lastNameTxt).sendKeys(lastName);
        driver.findElement(companyTxt).sendKeys(company);
        driver.findElement(address1Txt).sendKeys(address1);
        driver.findElement(address2Txt).sendKeys(address2);
        driver.findElement(countries).sendKeys(country);
        driver.findElement(stateTxt).sendKeys(state);
        driver.findElement(cityTxt).sendKeys(city);
        driver.findElement(zipCodeTxt).sendKeys(zipcode);
        driver.findElement(mobileNumber).sendKeys(mobileNim);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(createAccountBtn)));
        driver.findElement(createAccountBtn).click();
    }

    public String getCreateAccountAssertionMessage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(createAccountAssertion)));
        return driver.findElement(createAccountAssertion).getText();
    }

    public void clickContinue(){
        driver.findElement(continueBtn).click();
    }

    }
