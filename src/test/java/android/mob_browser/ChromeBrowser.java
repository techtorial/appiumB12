package android.mob_browser;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeBrowser {

    @Test
    public void chromeTest() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "techtorial");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        desiredCapabilities.setCapability("chromedriverExecutable", "/Users/techtorial/Downloads/AppiumB12/src/test/resources/chromedriver");

        URL url = new URL("http://localhost:4723/wd/hub");
        AndroidDriver androidDriver = new AndroidDriver(url, desiredCapabilities);
        androidDriver.get("https://facebook.com");






    }






}
