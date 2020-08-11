package testApiFramwork;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Classname ApiModel
 * @Description TODO
 * @Date 2020/8/10 3:46 下午
 * @Created by East
 */
public class ApiModel {
    public String name;
    public HashMap<String, ApiMethodModel> methods;

    public static ApiModel load(String path) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        try {
            return objectMapper.readValue(new File((path)), ApiModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void run(ApiMethodModel apiMethodModel) {
        apiMethodModel.run();
    }
}
