package io.lambdatest.tests;

import io.lambdatest.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class RegisterTest {

    @Test
    public void register() {
        WebDriver driver = DriverFactory.getDriver("chrome");
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }
}
