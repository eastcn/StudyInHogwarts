package testApp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import testFramwork.BasePage;

/**
 * @Classname AppBasePage
 * @Description TODO
 * @Date 2020/7/3 5:12 下午
 * @Created by East
 */
public class AppBasePage extends BasePage {
    private static AppiumDriver driver;
    private static WebDriverWait wait;


    public AppBasePage() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");


    }
}
