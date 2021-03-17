package com.prodyna.service;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitService {
    public AndroidDriver driver;

    public WaitService(AndroidDriver driver) {
        this.driver = driver;
    }

    public void waitUntilVisible(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
