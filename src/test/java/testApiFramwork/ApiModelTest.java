package testApiFramwork;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Classname ApiModelTest
 * @Description TODO
 * @Date 2020/8/10 4:51 下午
 * @Created by East
 */
class ApiModelTest {

    @Test
    void load() {
        String path = "src/main/resources/testFramwork/testApi.yaml";
        ApiModel api = ApiModel.load(path);
        assertThat(api.name, equalTo("wework"));
        System.out.println(api.name);
    }

    @Test
    void run() {
    }
}
