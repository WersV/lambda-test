package io.lambdatest.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccDashboardPage {

    public AccDashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='My Account']")
    private WebElement myAccHeader;

    public boolean isAccountDashboardShown() {
        try {
            return myAccHeader.isDisplayed();
        } catch(NoSuchElementException e) {
            return false;
        }
    }
}
