package io.lambdatest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/account']")
    private List<WebElement> myAccBtn;

    @FindBy(xpath = "//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/login']")
    private WebElement loginLiBtn;

    @FindBy(xpath = "//span[contains(text(), 'Register')]")
    private WebElement registerBtn;

    public RegisterPage goToRegisterPage() {
        Actions actions = new Actions(driver);
        myAccBtn.stream().filter(el -> el.isDisplayed()).findFirst().ifPresent(el -> actions.moveToElement(el).perform());
        registerBtn.click();
        return new RegisterPage(driver);
    }
}
