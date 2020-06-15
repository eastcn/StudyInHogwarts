package xueqiu.app.page;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchPageTest {

    static MainPage mainPage;
    static SearchPage searchPage;

    @BeforeAll
    static void beforeAll() {
        mainPage = new MainPage();
        searchPage = mainPage.toSearch();
    }

    @AfterAll
    static void afterAll() {
        mainPage.quit();
    }

    @ParameterizedTest
    @CsvSource({
            "alibaba,   阿里巴巴",
            "jd,    京东"
    })
    void search(String code, String name) {
        assertEquals(searchPage.search(code).getSearchList().get(0), name);
    }

    @ParameterizedTest
    @CsvSource({
            "alibaba, 阿里巴巴",
            "jd, 京东"
    })
    void getStockPrice(String code, String name) {
        assertTrue(searchPage.search(code).getStockPrice(name) > 200);

    }

    @ParameterizedTest
    @CsvSource({
            "alibaba, 09985",
            "百度, BIDU",
            "京东, JD"
    })
    void addSelfStock() {

    }
}
