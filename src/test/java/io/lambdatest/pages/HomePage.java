package io.lambdatest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(xpath = "//span[contains(text(), 'Login')]")
    private WebElement loginLiBtn;

    @FindBy(xpath = "//span[contains(text(), 'Register')]")
    private WebElement registerBtn;

    @FindBy(xpath = "//input[@name='search']")
    private List<WebElement> searchInputs;


    public RegisterPage goToRegisterPage() {
        Actions actions = new Actions(driver);
        myAccBtn.stream().filter(el -> el.isDisplayed()).findFirst().ifPresent(el -> actions.moveToElement(el).perform());
        registerBtn.click();
        return new RegisterPage(driver);
    }

    public LoginPage goToLoginPage() {
        Actions actions = new Actions(driver);
        myAccBtn.stream().filter(el -> el.isDisplayed()).findFirst().ifPresent(el -> actions.moveToElement(el).perform());
        loginLiBtn.click();
        return new LoginPage(driver);
    }

    public ProductDetailsPage searchProduct(String productName) {
        searchInputs.stream().filter(el-> el.isDisplayed()).findFirst().ifPresent(el -> el.sendKeys(productName));
        WebElement product = driver.findElement(By.xpath("//a[text()='"+productName+"']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", product);
        return new ProductDetailsPage(driver);
    }
}
