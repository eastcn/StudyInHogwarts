package xueqiu.app.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class MarketPage {
    private AppiumDriver driver;
    public MarketPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public SearchPage toSearch() {
        driver.findElementById("com.xueqiu.android:id/action_search").click();
        System.out.println("进入搜索页面");
        return new SearchPage(driver);
    }

    public List<WebElement> getStockList() {
        List<WebElement> elementList =  driver.findElements(By.id("com.xueqiu.android:id/name_and_symbol"));
        if(elementList.size()>0){
            System.out.println("当前自选股数量为" + elementList.size());
            for (WebElement element: elementList) {
                System.out.println(element.getText());
            }
        }
        return elementList;
    }

    public void deleteAStock(String name){
        TouchAction touchAction = new TouchAction(driver);
        Point location = driver.findElement(By.xpath(String.format("//*[@text='%s']",name))).getLocation();
        System.out.println("location:" + location);
        // 使用TouchAction 按住3秒后释放
        touchAction.press(PointOption.point(location)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).release();

        // 弹窗出现后搜索删除按钮并点击
        driver.findElement(By.xpath("//*[text='删除']")).click();
    }
}
