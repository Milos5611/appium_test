package com.prodyna.pages;

import com.prodyna.configuration.BasePageConfiguration;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePageConfiguration {


    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public static final String TEST_ACCOUNT_MAIL = "qaprodynatest@gmail.com";
    public static final String EMAIL_INVALID = "invalid";
    public static final String PASSWORD_VALID = "123456";
    public static final String PASSWORD_INVALID = "111111";
    public static final String ENTER_EMAIL_ERROR_TEXT = "Enter your email in order to identify your account";
    public static final String EMAIL_FORMAT_ERROR_TEXT = "Please add valid email address";





    @AndroidFindBy(accessibility = "Welcome to Placons")
    public AndroidElement welcomeTitle;

    @AndroidFindBy(accessibility = "Log In")
    public AndroidElement loginButton;

    @AndroidFindBy(accessibility = "Join")
    public AndroidElement joinButton;

    @AndroidFindBy(className = "android.widget.EditText")
    public AndroidElement emailInputField;

    @AndroidFindBy(accessibility = "Continue")
    public AndroidElement continueButton;

    @AndroidFindBy(className = "android.widget.ImageView")
    public AndroidElement backArrow;

    @AndroidFindBy(accessibility = "Enter your email in order to identify your account")
    public AndroidElement enterEmailErrorText;

    @AndroidFindBy(accessibility = "Please add valid email address")
    public AndroidElement emailFormatError;

    @AndroidFindBy(accessibility = "Enter passcode")
    public AndroidElement enterPasscode;

    @AndroidFindBy(accessibility = "1")
    public AndroidElement number1;

    @AndroidFindBy(accessibility = "2")
    public AndroidElement number2;

    @AndroidFindBy(accessibility = "3")
    public AndroidElement number3;

    @AndroidFindBy(accessibility = "4")
    public AndroidElement number4;

    @AndroidFindBy(accessibility = "5")
    public AndroidElement number5;

    @AndroidFindBy(accessibility = "6")
    public AndroidElement number6;

    @AndroidFindBy(accessibility = "7")
    public AndroidElement number7;

    @AndroidFindBy(accessibility = "8")
    public AndroidElement number8;

    @AndroidFindBy(accessibility = "9")
    public AndroidElement number9;

    @AndroidFindBy(accessibility = "0")
    public AndroidElement number0;

    @AndroidFindBy(accessibility = "Forgot passcode?")
    public AndroidDriver forgotPasscodeButton;

}
