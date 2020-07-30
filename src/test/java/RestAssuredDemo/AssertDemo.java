package RestAssuredDemo;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
/**
 * @Classname AssertDemo
 * @Description TODO
 * @Date 2020/7/26 1:44 下午
 * @Created by East
 */
public class AssertDemo {
    @Test
    void testAssertDemo(){
        when().get("http://eastfly.top:8089/api/movie/subjects?offset=0&limit=7")
                .then()
                .body(".subject.tag", hasItem("喜剧"));
    }
}
