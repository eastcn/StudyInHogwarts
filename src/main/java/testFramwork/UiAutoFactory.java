package testFramwork;

import testWeb.WebBasePage;

/**
 * @Classname UiAutoFactory
 * @Description TODO
 * @Date 2020/7/3 4:06 下午
 * @Created by East
 */
public class UiAutoFactory {
    public static BasePage createFactory(String driverName) {
        if (driverName.equals("app") || driverName.equals("appium")) {
            System.out.println("create app BasePage");
            return null;
        } else if (driverName.equals("web") || driverName.equals("selenium")) {
            return new WebBasePage();
        }
        return null;
    }
}
