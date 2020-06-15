package xueqiu.app.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage {
    private AppiumDriver driver;

    public MainPage() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");

        try {
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public SearchPage toSearch() {
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        return new SearchPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public MarketPage toMarket() {
        List<WebElement> elementList = driver.findElements(By.id("com.xueqiu.android:id/tab_name"));
        for (WebElement marketElement : elementList) {
            if (marketElement.getText().equals("行情")) {
                System.out.println("查找到'行情'按钮,进行点击");
                marketElement.click();
                System.out.println("进入'行情'页面");
            }
        }
        // 把当前页面的driver 传递给MarketPage
        return new MarketPage(driver);
    }

}
