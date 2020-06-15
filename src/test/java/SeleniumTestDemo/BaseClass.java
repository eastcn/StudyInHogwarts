package SeleniumTestDemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void initClass(){
        // 设置chrome drivedailyTemperaturesr
        ChromeOptions chromeOptions= new ChromeOptions();
        // 开启开发者模式
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(chromeOptions);
        // 显示等待控制, 参数：driver、 等待总时长、查找频率
        wait = new WebDriverWait(driver, 30, 1000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterAll
    public static void afterTest(){
        driver.quit();
    }
}
