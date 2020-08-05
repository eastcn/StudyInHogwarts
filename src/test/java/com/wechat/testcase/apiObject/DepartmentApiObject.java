package com.wechat.testcase.apiObject;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

/**
 * @Classname DepartmentApiObject
 * @Description TODO
 * @Date 2020/8/5 9:08 下午
 * @Created by East
 */
public class DepartmentApiObject {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentApiObject.class);

    public static Response createDepartment(String departmentName, String departmentNameEn, String accessToken) {
        logger.info("token:" + accessToken);
        String url = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=" + accessToken;
        String body = "{\n" +
                "   \"name\": \"" + departmentName + "\",\n" +
                "   \"name_en\": \"" + departmentNameEn + "\",\n" +
                "   \"parentid\": 1,\n" +
                "   \"order\": 1\n" +
                "}\n";
        return given()
                .when()
                .contentType("application/json")
                .body(body)
                .post(url)
                .then()
                .log()
                .body()
                .extract()
                .response();
    }

    public static Response deleteDepartment(int id, String token) {
        String url = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=" + token + "&id=" + id;
        return given()
                .when()
                .get(url)
                .then()
                .log()
                .body()
                .extract()
                .response();
    }

    public static Response getDepartmentList(String token) {
        String url = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=" + token;
        return given()
                .when()
                .get(url)
                .then()
                .log()
                .body()
                .extract()
                .response();
    }
}
