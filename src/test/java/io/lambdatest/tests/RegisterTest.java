package io.lambdatest.tests;

import io.lambdatest.models.User;
import io.lambdatest.pages.HomePage;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void register() {
        driver.get("https://ecommerce-playground.lambdatest.io/");

        User user = new User();
        new HomePage(driver).goToRegisterPage()
                .fillRegisterForm(user)
                .registerUser();
    }
}
