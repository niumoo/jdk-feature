package net.codingme.feature.jdk8;

import lombok.ToString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * JDK 8 steam 流操作
 *
 * @Author niujinpeng
 * @Date 2019/8/12 18:03
 */
public class Jdk8Stream {

    @Test
    public void test1() {

        // 不适用流操作
        List<String> names = Arrays.asList("Jack", "Jill", "Nate", "Kara", "Kim", "Jullie", "Paul", "Peter");

        // 筛选出长度为4的值
        List<String> subList = new ArrayList<>();
        for (String name : names) {
            if (name.length() == 4)
                subList.add(name);
        }
        // 把值用逗号分隔
        StringBuilder namesOfLength4 = new StringBuilder();
        for (int i = 0; i < subList.size() - 1; i++) {
            namesOfLength4.append(subList.get(i));
            namesOfLength4.append(", ");
        }
        if (subList.size() > 1) {
            namesOfLength4.append(subList.get(subList.size() - 1));
        }
        System.out.println(namesOfLength4);
        System.out.println("----------------");

        // 使用流操作
        String str = names.stream()
                .filter(num -> num.length() == 4)
                .collect(Collectors.joining(", "));
        System.out.println(str);
    }


    /**
     * map，注意，这里的map是进行1:1的转换映射，一般用于从前到后的内容和类型修改
     */
    @Test
    public void mapTest() {
        List<String> skills = Arrays.asList("java", "golang", "c++", "c", "python");
        // 添加中括号后输出
        skills.stream().map((skill) -> "[" + skill + "]").forEach(System.out::print);
        System.out.println();

        // 转换成大写后输出
        String str = skills.stream().map(skill -> skill.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(str);

        // 转换成大写后输出
        String str2 = skills.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(str2);
    }

    /**
     * reduce 字符串拼接例子
     */
    @Test
    public void reduceTest() {
        List<String> skills = Arrays.asList("java", "golang", "c++", "c", "python");
        String s = skills.stream().reduce((all, skill) -> all + skill).get();
        System.out.println(s);
    }

    /**
     * filter 过滤例子
     */
    @Test
    public void filterTest() {
        List<String> skills = Arrays.asList("java", "golang", "c++", "c", "python");
        List<String> strings = skills.stream().filter(skill -> skill.length() > 4).collect(Collectors.toList());
        strings.forEach(skill -> System.out.println(skill));
    }

    /**
     * 数据去重例子
     */
    @Test
    public void distinctTest() {
        List<String> skills = Arrays.asList("java", "golang", "c++", "c", "python", "java");
        List<String> collects = skills.stream().distinct().collect(Collectors.toList());
        collects.forEach(skill -> System.out.println(skill));
        System.out.println("---------------------------------------------");
        skills = Arrays.asList("java", "golang", "c++", "c", "python", "java");
        skills.stream().distinct().forEach(s -> System.out.println(s));
    }

    /**
     * 数学计算测试
     */
    @Test
    public void mathTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        IntSummaryStatistics stats = list.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("最小值" + stats.getMin());
        System.out.println("最大值" + stats.getMax());
        System.out.println("个数" + stats.getCount());
        System.out.println("和" + stats.getSum());
        System.out.println("平均数" + stats.getAverage());


    }
}
