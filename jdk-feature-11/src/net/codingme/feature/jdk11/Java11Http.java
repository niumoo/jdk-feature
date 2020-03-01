package net.codingme.feature.jdk11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/2/29 21:26
 */
public class Java11Http {

    public static void main(String[] args) throws IOException, InterruptedException {
        /* // 一次定义，多次使用
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                // 设置代理
                // .proxy(ProxySelector.of(new InetSocketAddress("asda",8100)))
                .build();
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://openjdk.java.net/jeps/321"))
                .timeout(Duration.ofSeconds(10))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofFile(Paths.get("file.json")))
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        */

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.hao123.com")).build();
        // 异步
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println)
            .join();

        // 同步
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
