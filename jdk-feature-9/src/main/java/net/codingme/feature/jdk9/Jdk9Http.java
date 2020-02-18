package net.codingme.feature.jdk9;

import java.io.IOException;
import java.net.URI;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

/**
 * @author 达西 - 公众号：未读代码
 */
public class Jdk9Http {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("http://www.tianqiapi.com/api/xxx");
        HttpRequest req = HttpRequest.newBuilder(uri).header("User-Agent", "Java").GET().build();
        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandler.asString());
        String body = resp.body();
        System.out.println(body);
    }

}
