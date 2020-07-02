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

public class MainPage extends BasePage{
//    private AppiumDriver driver;

    public MainPage() {
    }

    public SearchPage toSearch() {
//        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        click(By.id("home_search"));  // 使用自己封装的方法
        return new SearchPage(driver);
    }



    public MarketPage toMarket() {
        List<WebElement> elementList = findList(By.id("com.xueqiu.android:id/tab_name"));
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
