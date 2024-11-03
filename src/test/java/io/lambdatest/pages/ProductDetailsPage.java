package io.lambdatest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

    public ProductDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Buy now']")
    private WebElement buyNowBtn;

    public ProductDetailsPage buyProduct() {
        buyNowBtn.click();
        return this;
    }
}
