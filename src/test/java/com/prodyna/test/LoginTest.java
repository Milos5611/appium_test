package com.prodyna.test;

import com.prodyna.configuration.BaseTestConfiguration;
import com.prodyna.pages.Homepage;
import com.prodyna.pages.LoginPage;
import com.prodyna.service.AppiumService;
import com.prodyna.service.AssertService;
import com.prodyna.service.LoginService;
import com.prodyna.service.ResultService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import org.junit.rules.TestWatcher;
import org.junit.Rule;

import java.io.IOException;

import static com.prodyna.pages.LoginPage.*;


public class LoginTest extends BaseTestConfiguration {
    private static final Logger LOGGER = Logger.getLogger(LoginTest.class);

    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    @Before
    public void initialize() throws IOException {
        androidDriver = setup();
    }
    @Test
    public void loginHappyPathTest() throws InterruptedException {
        Homepage homepage = new Homepage(androidDriver);
        LoginService loginService = new LoginService(androidDriver);
        AssertService assertService = new AssertService(androidDriver);
        ResultService resultService = new ResultService(androidDriver);
        LoginPage loginPage = new LoginPage(androidDriver);


        loginService.login(TEST_ACCOUNT_MAIL, PASSWORD_VALID);

        assertService.assertElementIsDisplayed(homepage.week);

//        resultService.browserStackElementDisplayed(homepage.week);


    }

    @Test
    public void loginEmailNegativeTest() {
        LoginPage loginPage = new LoginPage(androidDriver);
        AppiumService appiumService = new AppiumService(androidDriver);
        AssertService assertService = new AssertService(androidDriver);
        ResultService resultService = new ResultService(androidDriver);

        appiumService.clickElement(loginPage.loginButton);

        appiumService.clickElement(loginPage.continueButton);
        assertService.assertElementIsDisplayed(loginPage.enterEmailErrorText);


        appiumService.clickElement(loginPage.emailInputField);
        appiumService.enterText(loginPage.emailInputField, EMAIL_INVALID);

        appiumService.clickElement(loginPage.continueButton);
        assertService.assertElementIsDisplayed(loginPage.emailFormatError);

//        resultService.browserStackElementDisplayed(loginPage.emailFormatError);


    }

    @After
    public void TearDown(){
        androidDriver.label("Stopping App");
        androidDriver.quit();
    }
//
//    @Test
//    public void letstry() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(androidandroidDriver);
//
//        new LoginService()
//                .enterPasscode("123456")
//                .login(TEST_ACCOUNT_MAIL, PASSWORD_VALID);
//    }

}
