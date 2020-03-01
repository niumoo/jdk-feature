package net.codingme.feature.jdk11;

import java.util.stream.Stream;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/2/29 20:44
 */
public class Java11String {
    public static void main(String[] args) {
        // 判空，blank里我放入了全角空格，半角空格，TAB
        String blank = "　　  ";
        System.out.println(blank.isBlank());
        System.out.println("-------------------------");

        // lines 返回一个 Stream
        String line = "a\nb\nc";
        Stream<String> lines = line.lines();
        // 使用 lambda 遍历
        lines.forEach(System.out::println);
        System.out.println("-------------------------");

        // 复制字符串
        String repeat = "我的微信:wn8398,";
        String repeat3 = repeat.repeat(3);
        System.out.println(repeat3);
        System.out.println("-------------------------");

        // 去除前后空白
        String strip = "   　 https://www.wdbyte.com 　";
        System.out.println("==" + strip.trim() + "==");
        // 去除前后空白字符，如全角空格，TAB
        System.out.println("==" + strip.strip() + "==");
        // 去前面空白字符，如全角空格，TAB
        System.out.println("==" + strip.stripLeading() + "==");
        // 去后面空白字符，如全角空格，TAB
        System.out.println("==" + strip.stripTrailing() + "==");
    }
}
