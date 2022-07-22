package android.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils {

    public static AndroidDriver initDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.APP,
                new File("src/test/resources/ApiDemos-debug-newVersion.apk").getAbsolutePath());
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "techtorial");
        desiredCapabilities.setPlatform(Platform.ANDROID);

        try{
            URL url = new URL("http://localhost:4723/wd/hub");
            AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);
            return driver;
        } catch (MalformedURLException ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }

    }




}
