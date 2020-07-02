package xueqiu.app.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage{
//    private AppiumDriver driver;

    public SearchPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public SearchPage search(String keyword) {
//        WebElement search_input = driver.findElement(By.id("com.xueqiu.android:id/search_input_text"));
        click(By.id("com.xueqiu.android:id/search_input_text"));
        return this;
    }

    public List<String> getSearchList() {
        List<WebElement> elements = findList(By.id("name"));
        List<String> names = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            names.add(elements.get(i).getText());
        }
        return names;

    }

    public double getStockPrice(String name) {
        // 找到对应name 的股票并点击
        find(By.xpath("//*[@text='" + name + "']")).click();
        System.out.println("定位到" + name + " 并点击");
        List<WebElement> elements = findList(By.id("com.xueqiu.android:id/current_price"));
        System.out.println("获取到" + name + " 股票价格");
        return Double.parseDouble(elements.get(0).getText());
    }

    public void quitSearch() {
        System.out.println("退出搜索页面");
        find(By.id("com.xueqiu.android:id/action_close")).click();
    }

    public void addSelfStock(String code) {
        find(By.xpath("//*@[text='" + code + "']/../../..//*[@text='加自选']")).click();
    }
}
