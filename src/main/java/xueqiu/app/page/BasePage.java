package xueqiu.app.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Classname BasePage
 * @Description TODO
 * @Date 2020/6/16 10:49 上午
 * @Created by East
 */
public class BasePage {
    AppiumDriver driver;
    WebDriverWait wait;

    public BasePage() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");

        try {
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 10);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void sendKey(By by, String msg) {
        // 移动端不需要显示等待
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(msg);
    }

    public void click(By by) {
//        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public void quit() {
        driver.quit();
    }

    public WebElement find(By by){
        return driver.findElement(by);
    }

    public List<WebElement> findList(By by){
        return driver.findElements(by);
    }
}
