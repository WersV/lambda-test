package io.lambdatest.pages;

import io.lambdatest.models.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;

    @FindBy(id = "input-email")
    private WebElement emailInput;

    @FindBy(id = "input-telephone")
    private WebElement telInput;

    @FindBy(id = "input-password")
    private WebElement passwInput;

    @FindBy(id = "input-confirm")
    private WebElement confirmPasswInput;

    @FindBy(xpath = "//input[@id='input-newsletter-yes']")
    private WebElement subYesRadio;

    @FindBy(id = "input-newsletter-no")
    private WebElement subNoRadio;

    @FindBy(id = "input-agree")
    private WebElement agreeCheck;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueBtn;

    public RegisterPage fillRegisterForm(User user) {
        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        emailInput.sendKeys(user.getEmail());
        telInput.sendKeys(user.getTelNumber());
        passwInput.sendKeys(user.getPassword());
        confirmPasswInput.sendKeys(user.getConfirmPassword());
        return this;
    }

    public AccPage registerUser() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",subYesRadio);
        executor.executeScript("arguments[0].click();", agreeCheck);
        continueBtn.click();
        return new AccPage(driver);
    }
}
