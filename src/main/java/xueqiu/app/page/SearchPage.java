package xueqiu.app.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.applet.Main;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private AppiumDriver driver;

    public SearchPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public SearchPage search(String keyword) {
        WebElement search_input = driver.findElement(By.id("com.xueqiu.android:id/search_input_text"));
        if (search_input.isDisplayed()) {
            System.out.println("查找到搜索页，输入:" + keyword);
            search_input.sendKeys(keyword);
        } else {
            System.out.println("未定位到搜索页，请重试");
        }
        return this;
    }

    public List<String> getSearchList() {
        List<WebElement> elements = driver.findElements(By.id("name"));
        List<String> names = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            names.add(elements.get(i).getText());
        }
        return names;

    }

    public double getStockPrice(String name) {
        // 找到对应name 的股票并点击
        driver.findElement(By.xpath("//*[@text='" + name + "']")).click();
        System.out.println("定位到" + name + " 并点击");
        List<WebElement> elements = driver.findElementsById("com.xueqiu.android:id/current_price");
        System.out.println("获取到" + name + " 股票价格");
        return Double.parseDouble(elements.get(0).getText());
    }

    public void quit() {
        System.out.println("退出搜索页面");
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();
    }

    public void addSelfStock(String code) {
        driver.findElement(By.xpath("//*@[text='" + code + "']/../../..//*[@text='加自选']")).click();
    }
}
