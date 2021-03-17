package com.prodyna.service;

import com.prodyna.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;

import static com.prodyna.pages.LoginPage.PASSWORD_VALID;
import static com.prodyna.pages.LoginPage.TEST_ACCOUNT_MAIL;

public class LoginService extends AppiumService {

    public LoginService(AndroidDriver driver){
        super(driver);
    }

    public void enterPasscode(String input){
        char[] digits = input.toCharArray();

        for (int i = 0; i < digits.length; i++){
            clickBasedOnValue(digits[i]);
        }
    }

    public void login(String email, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        clickElement(loginPage.loginButton);

        enterText(loginPage.emailInputField, email);
        clickElement(loginPage.continueButton);
        Thread.sleep(2000);
        enterPasscode(password);

    }
}
