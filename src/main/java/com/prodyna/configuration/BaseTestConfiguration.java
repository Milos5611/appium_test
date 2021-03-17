package com.prodyna.configuration;

import com.aventstack.extentreports.gherkin.model.And;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.Factory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestConfiguration {
    private static Platform platform = null;
    public EnhancedAndroidDriver androidDriver;


//    public static EnhancedAndroidDriver<AndroidElement> appCenterSetup(){
//
//    }




    public static EnhancedAndroidDriver<AndroidElement> setup() throws MalformedURLException {

        File file = new File("src");
        File appFile = new File(file, "app-stage-release.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();

//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "dd837c2c");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.APP, appFile.getAbsolutePath());

        capabilities.setCapability("useKeystore", true);
        capabilities.setCapability("keystorePath", "");
        capabilities.setCapability("keystorePassword", "abc");
        capabilities.setCapability("keyAlias", "abc");
        capabilities.setCapability("keyPassword", "abc");






        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        EnhancedAndroidDriver<AndroidElement> driver = Factory.createAndroidDriver(url,capabilities);

        return driver;


    }



    public static AndroidDriver<AndroidElement> browserStackTest() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "markobayer1");
        caps.setCapability("browserstack.key", "HFAtCo42kBTtQsbvt16x");

        // Set URL of the application under test
        caps.setCapability("app", "bs://c0a074912f74742a0d589a89cfe85cb48ed8ff06");

//        caps.setCapability("browserstack.user", "scvija1");
//        caps.setCapability("browserstack.key", "RxxyRDUzH8Ud9Ae2xHqC");
//
//        // Set URL of the application under test
//        caps.setCapability("app", "bs://85f9f4c95869e85319e66efd17eb0f5f8dae5bc9");

        // Specify device and os_version for testing
        caps.setCapability("device", "Samsung Galaxy S20");
        caps.setCapability("os_version", "10.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java Android");
        caps.setCapability("name", "first_test");




        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);


        /* Write your Custom code here */
        caps.setCapability("browserstack.networkLogs", "true");
        caps.setCapability("unicodeKeyboard", false);
        caps.setCapability("resetKeyboard", false);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
    return driver;
    }
}
