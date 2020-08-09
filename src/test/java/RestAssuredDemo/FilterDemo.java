package RestAssuredDemo;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Base64;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

/**
 * @Classname FilterDemo
 * @Description Filter的作用：对请求过程中的数据进行处理，其功能类似于在Charles和MitmProxy中修改请求数据
 * 多个filter时，会有顺序问题，按A-B-C->req send->aA-B-C->get response
 * @Date 2020/8/9 5:31 下午
 * @Created by East
 */
public class FilterDemo {
    @BeforeAll
    static void beforeAllFilter() {
        // 通过此方法来全局控制过滤
        RestAssured.filters((req, res, ctx) -> {
            return ctx.next(req, res);
        });
    }

    @Test
    void encodeOrdinaryJson() {
        given().get("https://ceshiren.com/c/job/31.json")
                .then()
                .body("users.name[0]", equalTo("思寒"));
    }

    @Test
    void encodeJson() {
        // filter 需要实现一个返回Response对象的函数，这边使用的是 匿名函数
        given().filter((req, res, ctx) -> {
            Response response = ctx.next(req, res); // 获取response, ctx.next 继续进入下一步
            String encodeBody = response.getBody().asString(); // 获取body
            // 新构建一个response 需要通过ResponseBuilder去构建， 通过clone去获取一个原有的response
            ResponseBuilder newRes = new ResponseBuilder().clone(response).setBody(Base64.getDecoder().decode(encodeBody.replace("\n", "").trim()));
            return newRes.build(); // 构造完后需要调用build生成最终的response
        }).get("http://127.0.0.1:8000/encode.json")
                .then()
                .body("users.name[0]", equalTo("思寒"));
    }

    @Test
    void sessionFilterDemo() {
        // 自动检测session
        SessionFilter sessionFilter = new SessionFilter();
        given().filter(sessionFilter)
                .get()
                .then()
                .log().all();
        System.out.println(sessionFilter.getSessionId());
    }
}
