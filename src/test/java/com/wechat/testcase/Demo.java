package com.wechat.testcase;

import com.wechat.testcase.apiObject.DepartmentApiObject;
import com.wechat.testcase.apiObject.TokenHelper;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Description;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * @Classname Demo
 * @Description 企业微信接口测试demo
 * @Date 2020/8/5 9:57 上午
 * @Created by East
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Demo {
    private static final Logger logger = LoggerFactory.getLogger(Demo.class);
    static String token;
    static int id;

    @BeforeAll
    static void getToken() {
        token = TokenHelper.getToken();
    }

    @Test
    @Description("创建部门")
    @Order(1)
    void createDepartment() {
        // demo version
//        String url = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=" + token;
//        String body = "{\n" +
//                "   \"name\": \"高管办公室\",\n" +
//                "   \"name_en\": \"Ofiice\",\n" +
//                "   \"parentid\": 1,\n" +
//                "   \"order\": 1\n" +
//                "}\n";
//        Response response = given()
//                .when()
//                .contentType("application/json")
//                .body(body)
//                .post(url)
//                .then()
//                .log()
//                .body()
//                .extract()
//                .response();
        // po模式
        logger.info("创建部门");
        String departmentName = "程序员办公室" + (int) System.currentTimeMillis() / 1000;
        String departmentNameEn = "en" + (int) System.currentTimeMillis() / 1000;
        Response res = DepartmentApiObject.createDepartment(departmentName, departmentNameEn, token);
    }

    @Test
    @Description("更新部门")
    @Order(2)
    void updateDepartment() {
        System.out.println("更新部门");
//        String url = "https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=" + token;
//        String body = "";
//        Response response = given()
//                .when()
//                .contentType("application/json")
//                .body(body)
//                .post(url)
//                .then()
//                .log()
//                .body()
//                .extract()
//                .response();
    }

    @Test
    @Description("删除部门")
    @Order(4)
    void deleteDepartment() {
//        String url = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=" + token + "&id=" + id;
//        Response response = given()
//                .when()
//                .get(url)
//                .then()
//                .log()
//                .body()
//                .extract()
//                .response();

        logger.info("删除部门：" + id);
        DepartmentApiObject.deleteDepartment(id, token);
    }

    @Test
    @Description("获取部门列表")
    @Order(3)
    void getDepartment() {
//        String url = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=" + token;
//        Response response = given()
//                .when()
//                .get(url)
//                .then()
//                .log()
//                .body()
//                .extract()
//                .response();
        logger.info("获取部门列表");
        Response response = DepartmentApiObject.getDepartmentList(token);
        id = response.path("department.id[-1]");
        logger.info("获取到的id为" + id);
    }

}
