package testWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testFramwork.BasePage;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class WebBasePage extends BasePage {
    private WebDriver driver;
    static WebDriverWait wait;

    /**
     * init
     */
    public WebBasePage() {
        ChromeOptions chromeOptions = new ChromeOptions();
        // 开启开发者模式
        chromeOptions.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/605.1.15 (KHTML, like Gecko) MicroMessenger/6.8.0(0x16080000) MacWechat/2.4.1(0x12040110) NetType/WIFI WindowsWechat");
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(chromeOptions);
        // 显示等待控制, 参数：driver、 等待总时长、查找频率
        wait = new WebDriverWait(driver, 30, 1000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * @param by    定位
     * @param value 输入值
     *              sendKeys功能
     */
    public void sendKeys(By by, String value) {
        System.out.println("input " + value);
        driver.findElement(by).sendKeys(value);
    }

    public void setCookies(String name, String value, String domain) {
        Cookie cookie = new Cookie(name, value, domain, null, null);
        driver.manage().addCookie(cookie);
    }

    public void setWindowSize(int x, int y) {
        driver.manage().window().setSize(new Dimension(x, y));
    }

    /**
     * @param by 定位
     *           点击功能
     */
    public void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public String getText(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by).getText();
    }

    /**
     * @param map 加载yaml文件后生成的click类型的HashMap的定位方式
     */
    @Override
    public void click(HashMap<String, Object> map) {
        System.out.println("test click");
        By by = checkMethod(map);
        click(by);
    }

    /**
     * @param url 需要跳转的url
     */
    public void get(String url) {
        System.out.println("get " + url);
        driver.get(url);
    }

    /**
     * @param map   加载yaml文件后生成的input类型的HashMap的定位方式
     * @param value 需要input的数据
     */
    @Override
    public void sendKeys(HashMap<String, Object> map) {
        System.out.println("test input ");
        By by = checkMethod(map);
        sendKeys(by, map.get("value").toString());
    }

    @Override
    public void getText(HashMap<String, Object> map) {
        System.out.println("test getText");
        By by = checkMethod(map);
        System.out.println(getText(by));
    }

    /**
     * @param map 传入HashMap结构的数据内容，根据内容确定定位方式
     * @return 返回一个By类型的locator
     */
    private By checkMethod(HashMap<String, Object> map) {
        // 根据传入的定位符的方式分为：id、linkTest、partialLinkText、xPath,
        By by = null;
        String actionKey = (String) map.keySet().toArray()[0]; // 根据case模型定义，第一层map的key为动作
        HashMap<String, Object> actionValue = (HashMap<String, Object>) map.get(actionKey);
        System.out.println(actionKey + ":");
        String locatorKey = (String) actionValue.keySet().toArray()[0]; // 第二层为 定位方式：id等
        String locatorValue = actionValue.get(locatorKey).toString();
        if (locatorKey.toLowerCase().equals("id")) {
            System.out.println("by id:" + locatorValue);
            by = By.id(locatorValue);
        } else if (locatorKey.toLowerCase().equals("linkText".toLowerCase())) {
            System.out.println("by linkText:" + locatorValue);
            by = By.linkText(locatorValue);
        } else if (locatorKey.toLowerCase().equals("partialLinkText".toLowerCase())) {
            System.out.println("by partialLinkText:" + locatorValue);
            by = By.partialLinkText(locatorValue);
        } else if (locatorKey.toLowerCase().equals("xpath")) {
            System.out.println("by xpath:" + locatorValue);
            by = By.xpath(locatorValue);
        }
        return by;
    }

    /**
     * @param map load解析的yaml文件中的每一个step
     *            该方法用于实现一些 非通用基础方法，可以自定义灵活实现，具体方法为在条件语句中增加判断
     */
    public void action(HashMap<String, Object> map) {
//        super.action(map); // 如果在父类方法中也有定义通用方法，则需要先运行父类通用方法
        if (map.containsKey("action")) {
            String actionValue = map.get("action").toString();
            if (actionValue.toLowerCase().equals("自定义方法")) {
                System.out.println("此处实现自定义方法");
            } else if (actionValue.toLowerCase().equals("get")) {
                System.out.println("test action: get");
                System.out.println("get:" + map.get("url").toString());
                driver.get(map.get("url").toString());
            }

        }
    }

    /**
     * 退出网页
     */
    public void quit() {
//        driver.close();
        System.out.println("driver quit");
        driver.quit();
    }

    /**
     * 关闭当前浏览器页面
     */
    public void close() {
//        driver.close();
        System.out.println("driver close");
        driver.close();
    }

}
