package android.pages;

import android.utils.DriverUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class HomePage {

    TouchAction touchAction;

    public HomePage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        touchAction = new TouchAction(driver);
    }

    @FindBy(xpath = "//*[@text='Views']")
    private WebElement views;


    public void tapOnViews() {
       touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();
    }






}
