package com.prodyna.service;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.JavascriptExecutor;

public class ResultService extends AppiumService{

    public ResultService(AndroidDriver driver) {
        super(driver);
    }

    public void browserStackElementDisplayed(AndroidElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        if(isElementDisplayed(element)){

            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": " +
                    "{\"status\": \"passed\", \"reason\": \"Field found\"}}");
        } else {
            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\":" +
                    "{\"status\":\"failed\", \"reason\": \"Field not found\"}}");
        }
    }
}
