package testFramwork;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasePageTest {
    private BasePage basePage = new BasePage();
    @Test
    void run() {
        UIAuto uiAuto = basePage.load("/testFramwork/testWeb.yaml");
        basePage.run(uiAuto);
    }
}