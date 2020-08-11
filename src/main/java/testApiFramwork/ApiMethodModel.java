package testApiFramwork;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

/**
 * @Classname API调用接口的参数模型
 * @Description TODO
 * @Date 2020/8/10 3:46 下午
 * @Created by East
 */
public class ApiMethodModel {
    public String method;
    public String url;
    public HashMap<String, Object> query;

    public void run() {
        given().queryParams(query).request(method, url).then();
    }
}
