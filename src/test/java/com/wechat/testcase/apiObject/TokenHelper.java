package com.wechat.testcase.apiObject;

import com.wechat.testcase.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

/**
 * @Classname TokenHelper
 * @Description Token相关方法
 * @Date 2020/8/5 9:50 下午
 * @Created by East
 */
public class TokenHelper {
    private final static String corpid = "xxx";
    private final static String corpsecret = "xxxx";
    private static final Logger logger = LoggerFactory.getLogger(Demo.class);

    public static String getToken() {
        String accessToken = given()
                .params("corpid", corpid)
                .params("corpsecret", corpsecret)
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().statusCode(200).extract().body().path("access_token");
        logger.info("获取到token为：" + accessToken);
        return accessToken;
    }
}
