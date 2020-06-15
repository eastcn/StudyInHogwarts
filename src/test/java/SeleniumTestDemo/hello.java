package SeleniumTestDemo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hello {
    @Test
    public void helloSelenium(){
        WebDriver driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver", "/Users/hefeng/Documents/selenium/chromedriver");
        driver.get("https://www.baidu.com");
    }
}
