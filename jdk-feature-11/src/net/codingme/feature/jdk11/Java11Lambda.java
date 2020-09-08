package net.codingme.feature.jdk11;

import java.util.HashMap;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/2/29 21:02
 */
public class Java11Lambda {

    public static void main(String[] args) {
        var hashMap = new HashMap<String, Object>();
        hashMap.put("wechat", "wn8398");
        hashMap.put("website", "https://www.wdbyte.com");
        hashMap.forEach((var k, var v) -> {
            System.out.println(k + ": " + v);
        });

        hashMap.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

        // hashMap.forEach((String k, var v) -> {
        // System.out.println(k + ": " + v);
        // });

    }
}
