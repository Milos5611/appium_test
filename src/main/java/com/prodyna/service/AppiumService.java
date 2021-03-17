package com.prodyna.service;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;

public class AppiumService {
    public AndroidDriver driver;

    public AppiumService(AndroidDriver driver) {
        this.driver = driver;
    }

    public void enterText(AndroidElement element, String inputText) {

        element.click();

        String letter = "";
        for(int i =0; i< inputText.length(); i++){
            letter = String.valueOf(inputText.charAt(i)).toUpperCase();
            if(letter.equals("@")){
                letter = "AT";
            }
            if(letter.equals(".")){
                letter="PERIOD";
            }
            ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.valueOf(letter)));
        }

    }

    public void clickElement(AndroidElement element) {
        WaitService wait = new WaitService(driver);
//        wait.waitUntilVisible(element);
        element.click();
    }

    public String getFieldText(AndroidElement element) {
        return element.getAttribute("value");
    }

    public void clickBasedOnValue(char number) {
        driver.findElementByAccessibilityId(String.valueOf(number)).click();
    }

    public boolean isElementDisplayed(AndroidElement element) {

        boolean isElementDisplayedValue;
        try {
            isElementDisplayedValue = element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException ex) {
            isElementDisplayedValue = false;
        }
        return isElementDisplayedValue;
    }
}
