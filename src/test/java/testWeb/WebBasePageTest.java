package testWeb;

import org.junit.jupiter.api.Test;
import testFramwork.BasePage;
import testFramwork.UIAuto;
import testFramwork.UiAutoFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Classname WebBasePageTest
 * @Description TODO
 * @Date 2020/7/3 2:30 下午
 * @Created by East
 */
class WebBasePageTest {

    static BasePage basePage = UiAutoFactory.createFactory("web");
    @Test
    void testWeb() {
        UIAuto uiAuto = basePage.load("/testFramwork/testWeb.yaml");
        basePage.run(uiAuto);
    }
}
