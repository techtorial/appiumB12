package android;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.apache.tools.ant.taskdefs.Touch;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.security.krb5.internal.crypto.Des;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Gestures {


    @Test
    public void tapTest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.APP,
                new File("src/test/resources/ApiDemos-debug-newVersion.apk").getAbsolutePath());

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "techtorial");
        desiredCapabilities.setPlatform(Platform.ANDROID);
        URL url = new URL("http://localhost:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);

        WebElement viewsButton = driver.findElementByAndroidUIAutomator("text(\"Views\")");

//        viewsButton.click();

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsButton)))
                .perform();
    }

    @Test
    public void longPressTest() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.APP,
                new File("src/test/resources/ApiDemos-debug-newVersion.apk").getAbsolutePath());

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "techtorial");
        desiredCapabilities.setPlatform(Platform.ANDROID);
        URL url = new URL("http://localhost:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);

        WebElement viewsButton = driver.findElementByAndroidUIAutomator("text(\"Views\")");

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsButton))).perform();

        WebElement expandableList = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
        touchAction
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(expandableList))).perform();

        WebElement customAdapter = driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")");
        touchAction
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdapter))).perform();


        WebElement peopleNames =
                driver.findElementByAndroidUIAutomator("text(\"People Names\")");

        touchAction.longPress(
                        LongPressOptions.longPressOptions()
                                .withElement(ElementOption.element(peopleNames))
                                .withDuration(Duration.ofSeconds(2)))
                .perform();

    }

    @Test
    public void scrollTest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.APP,
                new File("src/test/resources/ApiDemos-debug-newVersion.apk").getAbsolutePath());

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "techtorial");
        desiredCapabilities.setPlatform(Platform.ANDROID);
        URL url = new URL("http://localhost:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);

        WebElement viewsButton = driver.findElementByAndroidUIAutomator("text(\"Views\")");

        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsButton))).perform();

        WebElement secureView =
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Secure View\"))");





    }
}
