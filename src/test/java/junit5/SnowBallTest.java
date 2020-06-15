package junit5;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class SnowBallTest extends BaseTest {
    /**
     * 根据findElement 获取element，通过getAttribute方法获取对应属性的值
     */
    @Test
    public void EnableTest() {

        WebElement element = driver.findElement(By.id("com.xueqiu.android:id/home_search"));
        if (element.getAttribute("enabled").equals("true")) { // 或者element.isEnabled
            System.out.println("搜索框可用" + "坐标：" + element.getLocation());
            element.click();
            WebElement search_input = driver.findElement(By.id("com.xueqiu.android:id/search_input_text"));
            if (search_input.getAttribute("displayed").equals("true")) { // 或者这种写法search_input.isDisplayed()
                System.out.println("搜索成功");
            } else {
                System.out.println("搜索失败");
            }
        }
    }

    @Test
    public void TouchTest() {
        // 通过manage().window().getSize()获取评屏幕的宽度和高度
        int screenWidth = driver.manage().window().getSize().getWidth();
        int screeHeight = driver.manage().window().getSize().getHeight();
        System.out.println("宽:" + screenWidth + "  高:" + screeHeight);
        try {
            // app启动较慢，所以需要进行时间等待
            Thread.sleep(10000);

            // 实例化一个TouchAction
            TouchAction touchAction = new TouchAction(driver);

            // 动作内容： 按住-滑动-释放
            System.out.println("开始进行动作");
            touchAction.press(PointOption.point((int) (screenWidth * 0.5), (int) (screeHeight * 0.5))) // press 在指定坐标点按住
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))) // 等待2秒后进行滑动
                    .moveTo(PointOption.point((int) (screenWidth * 0.5), (int) (screeHeight * 0.2))) // 滑动到指定坐标
                    .release() // 释放
                    .perform();  // 执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void SwipeUnlockTest() {

    }

}
