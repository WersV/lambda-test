package io.lambdatest.tests;

import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void register() {
        driver.get("https://ecommerce-playground.lambdatest.io/");
    }
}
