package RestAssuredDemo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;

/**
 * @Classname demo
 * @Description TODO
 * @Date 2020/7/25 9:49 下午
 * @Created by East
 */
public class demo {
    public static String token;
    public final static String corpid = "corpid";
    public final static String corpsecret = "corpsecret";

    @BeforeAll
    @Test
    static void AssuredGet() {
        token = given()
                .params("corpid", corpid)
                .params("corpsecret", corpsecret)
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().statusCode(200).extract().body().path("access_token");
        System.out.println(token);
    }

    @Test
    void AssuredPost() throws MalformedURLException {
        URL url = new URL("https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=" + token);

        given().body("{\n" +
                "   \"touser\" : \"@all\",\n" +
                "   \"msgtype\" : \"text\",\n" +
                "   \"agentid\" : 1000002,\n" +
                "   \"text\" : {\n" +
                "       \"content\" : \"你的快递已到，请携带工卡前往邮件中心领取。\\n出发前可查看<a href=\\\"http://work.weixin.qq.com\\\">邮件中心视频实况</a>，聪明避开排队。\"\n" +
                "   },\n" +
                "   \"safe\":0,\n" +
                "   \"enable_id_trans\": 0,\n" +
                "   \"enable_duplicate_check\": 0,\n" +
                "   \"duplicate_check_interval\": 1800\n" +
                "}").contentType("application/json;charset=utf-8").post(url).
                then().log().all();
//        System.out.println(token);
    }
}
