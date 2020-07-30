package sparkJava;

import org.slf4j.Logger;

import java.util.Arrays;

import static spark.Spark.*;

/**
 * @Classname demo
 * @Description spark java demo
 * @Date 2020/7/30 10:00 下午
 * @Created by East
 */
public class demo {

    public static void main(String[] args) {
        final int[] local = {0};
        // 如果不指定端口，则默认运行在 4567端口
        port(8080);
        // 可以指定线程池大小， 也可以同时指定最小线程池但是必须同时给定超时时间
        threadPool(8, 2, 3000);
        get("/hello/:p", (req, res) -> {
            // do something
            System.out.println("this is path params" + req.params(":p"));
            System.out.println("this is query String" + req.queryString());
            System.out.println("this is query map" + req.queryMap());
            System.out.println("this is query map-key" + Arrays.toString(req.queryParamsValues("p")));
            System.out.println("this is query params keys" + req.queryParams());
            System.out.println("this is query params certain value" + req.queryParams("p"));

            return "hello world";
        });

        post("/postHello", (request, response) -> {
            // do something
            System.out.println("this is post");
            return "post hello world";
        });

        put("/putHelloWorld", (request, response) -> {
            // update something
            System.out.println(local[0]);
            local[0]++;
            System.out.println(local[0]);
            return local[0];
        });

        delete("/delete", (request, response) -> {
            // delete something
            System.out.println("delete local");
            return "success";
        });
    }
}
