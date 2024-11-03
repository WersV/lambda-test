package io.lambdatest.tests;

import io.lambdatest.models.User;
import io.lambdatest.pages.AccDashboardPage;
import io.lambdatest.pages.HomePage;
import io.lambdatest.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void login() {
        driver.get("https://ecommerce-playground.lambdatest.io/");

        AccDashboardPage dashboardPage = new HomePage(driver).goToLoginPage().loginUser("123test@email.pl", "SecretPassword1!");
        Assert.assertTrue(dashboardPage.isAccountDashboardShown(),"My Account dashboard should be displayed on AccDashboardPage");
    }
}
