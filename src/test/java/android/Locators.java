package android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Locators {

    @Test
    public void androidSpecificLocator() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "techtorial");

        File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        URL appiumServerUrl = new URL("http://localhost:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(appiumServerUrl, desiredCapabilities);

        WebElement viewsButton = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        viewsButton.click();
    }


}
