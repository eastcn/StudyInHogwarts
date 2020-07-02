package junit5;

import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelloWordDemo {
    private static AppiumDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void setDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("noReset", "true");
        /* 雪球 */
         desiredCapabilities.setCapability("appPackage","com.xueqiu.android");
         desiredCapabilities.setCapability("appActivity",".view.WelcomeActivityAlias");
        /* snkrs */
//        desiredCapabilities.setCapability("appPackage","com.nike.snkrs");
//        desiredCapabilities.setCapability("appActivity",".main.activities.SnkrsActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void helloSnowBallDemo() {

        // 定位搜索框
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();

        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys("alibaba");
        driver.findElement(By.xpath("//*[@text='BABA']")).click();
//        String price = driver.findElement(By.id("com.xueqiu.android:id/current_price")).getText();
//        System.out.println(price);
        List<WebElement> elements= driver.findElementsById("com.xueqiu.android:id/current_price");
        System.out.println(elements.get(0).getText());
    }

    @Test
    public void findElementByXpath(){
    }

    /**
     * 使用安卓sdk自带的uiautomator工具查找元素。
     * 查询用法地址：
     * 常用写法有： resourceId("id")
     */
    @Test
    public void findElementByUiAutomator(){
        // 使用 UiAutomator的 UiSelector等方法 需要将driver 强转为 AndroidDriver<MobileElement>
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) this.driver;
            //UiSelector 根据resourceId查询
//        driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.xueqiu.android:id/tab_name\")").click();
            //UiSelector 根据className定位
//        driver.findElementByAndroidUIAutomator("new UiSelector().className(\"com.xueqiu.android:id/tab_name\").text(\"行情\")").click();
        try {
            Thread.sleep(10000);
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Tie-Dye\").instance(0))");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void waitTestDemo(){
        wait=new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("//*[@text='Space Hippie']")));
        System.out.println("可以点击");
        driver.findElement(By.id("com.nike.snkrs:id/item_threadgroup_single_column_card_imageview")).click();
    }
}
