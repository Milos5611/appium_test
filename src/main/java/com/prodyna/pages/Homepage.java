package com.prodyna.pages;

import com.prodyna.configuration.BasePageConfiguration;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Homepage extends BasePageConfiguration {

    public Homepage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Notifications")

    public AndroidElement notifications;

    @AndroidFindBy(accessibility = "Top News")
    public AndroidElement topNews;

    @AndroidFindBy(accessibility = "Week")
    public  AndroidElement week;

    @AndroidFindBy(accessibility = "Energy comparison by Verivox")
    public  AndroidElement verivox;
}
