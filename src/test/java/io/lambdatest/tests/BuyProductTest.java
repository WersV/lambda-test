package io.lambdatest.tests;

import io.lambdatest.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BuyProductTest extends BaseTest{

    @Test
    public void buyProduct() {
        driver.get("https://ecommerce-playground.lambdatest.io/");

        new HomePage(driver).searchProduct("MacBook").buyProduct();
    }
}
