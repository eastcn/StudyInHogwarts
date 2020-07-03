package testFramwork;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.HashMap;

public class BasePage {

    public void click(HashMap<String, Object> map) {
        // 具体方法读取到的数据应该已经是根据id或者xpath等定位方式去执行操作。
        System.out.println("click:" + map);

    }

    public void sendKeys(HashMap<String, Object> map) {
    }

    public void find() {
    }

    public void action(HashMap<String, Object> map) {
        // 留一个通用的方法去实现特殊的动作
    }

    /**
     * @param uiAuto UI自动化用用例的case模型结构
     *  传入case的模型结构进行执行，根据case中的关键字判断需要执行哪些action
     */
    public void run(UIAuto uiAuto) {
        uiAuto.steps.stream().forEach(step -> {
                    if (step.containsKey("click")) {
//                        HashMap<String, Object> hashMap = (HashMap<String, Object>) step.get("click");
//                        System.out.println(hashMap.toString());
                        click(step);
                    }
                    if (step.containsKey("input")) {
//                        HashMap<String, Object> map = (HashMap<String, Object>) step.get("input");
//                        String value = step.get("value").toString();
                        sendKeys(step);
                    }
                    if (step.containsKey("action")) {
                        action(step);
                    }
                }
        );
    }

    public UIAuto load(String path) {
        // 定义一个读取yaml的mapper
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        UIAuto uiAuto;
        try {
            // 从resource 中读取文件并转成 uiAuto结构
            uiAuto = mapper.readValue(BasePage.class.getResourceAsStream(path), UIAuto.class);
            System.out.println(uiAuto.toString());
            return uiAuto;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
