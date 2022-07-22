package android.tests;

import android.pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class HomePageTest {

    @Test
    public void homeTest() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "techtorial");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,
                new File("src/test/resources/ApiDemos-debug-newVersion.apk").getAbsolutePath());

        URL url = new URL("http://localhost:4723/wd/hub");

        AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);
        HomePage homePage = new HomePage(driver);
        homePage.tapOnViews();
    }
}
