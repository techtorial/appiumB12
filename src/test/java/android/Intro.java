package android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Intro {

    @Test
    public void firstTest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        desiredCapabilities.setCapability("deviceName", "techtorial");
        desiredCapabilities.setCapability("platformName", "android");

        File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");

        desiredCapabilities.setCapability("app", apkFile.getAbsolutePath());

        URL appiumServer = new URL("http://localhost:4723/wd/hub");
        //0.0.0.0 -> localhost -> 127.0.0.0

        AndroidDriver driver = new AndroidDriver(appiumServer, desiredCapabilities);


        WebElement appButton = driver.findElement(By.xpath("//android.widget.TextView[@text='App']"));
        Assert.assertEquals("App", appButton.getText());
        appButton.click();

    }

    @Test
    public void idTest() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "techtorial");

        File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());

        URL appiumServerUrl = new URL("http://localhost:4723/wd/hub");
        AppiumDriver driver = new AndroidDriver(appiumServerUrl, desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        // click on Views
        WebElement viewButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
        viewButton.click();

        // click on Buttons
        WebElement buttonButton = driver.findElement(By.xpath("//*[@text='Buttons']"));
        buttonButton.click();

        // locate Normal button using id element
        WebElement normalButton = driver.findElement(By.id("io.appium.android.apis:id/button_normal"));

        // validate it's displayed
        Assert.assertTrue(normalButton.isDisplayed());

        // validate its text
        Assert.assertEquals("NORMAL", normalButton.getText());

        WebElement smallButton = driver.findElement(AppiumBy.accessibilityId("Small"));

        Assert.assertTrue(smallButton.isDisplayed());
        Assert.assertEquals("SMALL", smallButton.getText());





    }


}
