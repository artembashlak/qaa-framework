package com.github.emilshina.testcases;

import com.github.emilshina.model.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Authorization tests.
 */
@Slf4j
public class AuthorizationTests extends BaseClass {

    @BeforeMethod
    public void beforeEachMethod(final ITestContext context, final Method method) {
        final String browser = context.getCurrentXmlTest().getParameter("browser");
        log.info("Before method of Auth class in browser {} {}", browser, method.getName());

    }

    @AfterMethod
    public void afterEachMethod() {
        log.info("After method of Auth class.");
    }

    @Test(dataProvider = "userCredentials", dataProviderClass = DataSuppliers.class)
    public void userShouldBeAuthorizedWithValidCredentials(final HashMap.SimpleEntry credentials) {
        log.info("com.github.emilshina.model.User was authorized successfully. With {} ", credentials);
    }

    @Data(source = "data.json")
    @Test(dataProvider = "usersWithInvalidCredentials", dataProviderClass = DataSuppliers.class)
    public void userShouldNotBeAuthorizedWithInvalidLogin(final User user) {
        final SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(user.getUserName()).as("Username verification.").isEqualTo("username1");
        log.info("Invalid credentials for: {}.", user.getUserName());
        softAssertions.assertAll();
    }

    @Test(dataProvider = "invalidPassword", dataProviderClass = DataSuppliers.class)
    public void userShouldNotBeAuthorizedWithInvalidPassword(final String password) {
        log.info("Invalid credentials. Try again. Password {}.", password);

    }
}
