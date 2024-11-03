package io.lambdatest.pages;

import io.lambdatest.models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "input-email")
    private WebElement emailInput;


    @FindBy(id = "input-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit' and @value='Login']")
    private WebElement loginBtn;

    public AccDashboardPage loginUser(String login, String password) {
        emailInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginBtn.click();
        return new AccDashboardPage(driver);
    }
}
