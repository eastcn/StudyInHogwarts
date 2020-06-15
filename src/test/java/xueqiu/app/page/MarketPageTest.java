package xueqiu.app.page;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarketPageTest {
    static MarketPage marketPage;
    static MainPage mainPage;

    @BeforeAll
    static void beforeAll() {
        mainPage = new MainPage();
        marketPage = mainPage.toMarket();
    }

    @Test
    public void getStockList() {
        List<WebElement> list = marketPage.getStockList();
        assertTrue(list.size() > 0, "有1支以上股票");
    }
}
