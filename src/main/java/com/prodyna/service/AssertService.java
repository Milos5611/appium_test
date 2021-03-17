package com.prodyna.service;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import org.apache.tools.ant.taskdefs.condition.And;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;


public class AssertService extends AppiumService {

    public AssertService(AndroidDriver driver) {
        super(driver);
    }

    public void assertElementsAreDisplayed(AndroidElement... elements) {
//        SoftAssert softAssert = new SoftAssert();

        for (AndroidElement element : elements) {
//            softAssert.
           assertTrue(element.isDisplayed());
        }
       
    }

    public void assertElementIsDisplayed(AndroidElement element) {
        WaitService wait = new WaitService(driver);

//        wait.waitUntilVisible(element);
        boolean isElementDisplayedValue;
        try {
            isElementDisplayedValue = element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException ex) {
            isElementDisplayedValue = false;
        }
        assertTrue(isElementDisplayedValue);
    }

    public void assertElementTextEqualsText(AndroidElement element, String expectedText) {
        String elementText = element.getText();
        assertTrue(elementText.equalsIgnoreCase(expectedText));

    }
}
