package SeleniumTestDemo;

import junit5.BaseTest;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class testEastBlog extends BaseClass {


    @Test
    public void testDemo(){
        driver.get("http://eastfly.top");
        // ExpectedCondition 为接口类，自行实现一个判断是否满足条件的类，使用lambda表达式
        try {
            wait.until((ExpectedCondition<Boolean>) webDriver -> driver.findElements(By.className("postTitle")).size()>1);
            // 等待结束
            System.out.println("find true");
            List<WebElement> elementList = driver.findElements(By.className("postTitle"));
            for (WebElement element : elementList){
                if (element.getText().contains("Selenium")) {
                    element.click();
                    System.out.println("find element and click ");
                    break;
                }
            }
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void LoginZhihu(){
        driver.get("https://www.zhihu.com/signin?next=%2Fhot");
        driver.findElement(By.xpath("//*[@class='SignFlow-tab']")).click();
        System.out.println("切换到密码登录");
        driver.findElement(By.name("username")).sendKeys("17826805734");
        System.out.println("输入账号");
        driver.findElement(By.name("password")).sendKeys("EASTlove7!");
        System.out.println("输入密码");
        driver.findElement(By.xpath("//*[@text='登录']")).click();
        System.out.println("点击登录");
    }

}
