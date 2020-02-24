package net.codingme.feature.jdk10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * var: 类型推断
 */
public class Java10Var {

    public static void main(String[] args) {
        var hashMap = new HashMap<String, String>();
        hashMap.put("微信", "wn8398");
        var string = "hello java 10";
        var stream = Stream.of(1, 2, 3, 4);
        var list = new ArrayList<String>();

        String var = "hello";
        testVar();
    }

    public static void testVar() {
        // 情况1，没有初始化会报错
        // var list;
        var list = List.of(1, 2, 3, 4);
        // 情况2
        for (var integer : list) {
            System.out.println(integer);
        }
        // 情况3
        for (var i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
