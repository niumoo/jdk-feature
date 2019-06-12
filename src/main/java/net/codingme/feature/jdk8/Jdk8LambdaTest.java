package net.codingme.feature.jdk8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * <p>
 * Lambda 表达式测试
 * <p>
 * (params) -> expression
 * <p>
 * (params) -> statement
 * <p>
 * (params) -> { statements; }
 * <p>
 * Lambda 几个特征 - 可选的类型声明，编译器可以自动识别 - 可选的参数括号，一个
 *
 * @Author niujinpeng
 * @Date 2019/2/17 14:48
 */
public class Jdk8LambdaTest {

    /**
     * 使用 ()->{} 代替匿名内部类
     * 
     */
    @Test
    public void runnableTest() {
        // before jdk8
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("before jdk8 runnable start ...");
            }
        }).start();

        // in jdk8
        new Thread(() -> {
            System.out.println("in jdk8 runnable start ....");
        }).start();

        System.out.println("over....");
    }

    /**
     * 新的遍历方式
     */
    @Test
    public void foreachTest() {
        List<String> skills = Arrays.asList("java", "golang", "c++", "c", "python");
        // before jdk8
        for (String skill : skills) {
            System.out.println(skill);
        }
        System.out.println("-------------------");
        // in jdk8
        skills.forEach((skill) -> System.out.println(skill));
        System.out.println("-------------------");
        skills.forEach(System.out::println);
    }

    /**
     * 函数接口
     */
    @Test
    public void functionInterfaceTest() {
        List<String> skills = Arrays.asList("java", "golang", "c++", "c", "python");
        Predicate<String> length4 = (str) -> str.length() > 4;
        filterByForeach(skills, length4);
        System.out.println("----------------------");
        filterByFilter(skills, length4);
    }

    /**
     * 接收函数参数
     * 
     * @param list
     * @param condition
     */
    public void filterByForeach(List list, Predicate condition) {
        list.forEach(a -> {
            if (condition.test(a)) {
                System.out.print(a + " ");
            }
        });
    }

    /**
     * 接收函数参数
     * 
     * @param list
     * @param condition
     */
    public void filterByFilter(List list, Predicate condition) {
        list.stream().filter(a -> condition.test(a)).forEach(a -> System.out.print(a + (" ")));
    }

    /**
     * predicate 的复杂使用
     */
    @Test
    public void predicateTest() {
        Predicate<String> startsWith = (str) -> str.startsWith("g");
        Predicate<String> length = (str) -> str.length() > 4;

        List<String> skills = Arrays.asList("java", "golang", "c++", "c", "python");
        skills.stream().filter(startsWith.and(length)).forEach((skill) -> {
            System.out.print(skill + " ");
        });
    }

    /**
     * map，注意，这里的map是进行1:1的转换映射，一半用于从前到后的内容和类型修改
     */
    @Test
    public void mapTest() {
        List<String> skills = Arrays.asList("java", "golang", "c++", "c", "python");
        skills.stream().map((skill) -> "[" + skill + "]").forEach(skill -> {
            System.out.println(skill);
        });

        List<String> skills2 = Arrays.asList("java", "golang", "c++", "c", "python");
        String str = skills.stream().map(skill -> skill.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(str);
    }

    /**
     * reduce 测试
     */
    @Test
    public void reduceTest() {
        List<String> skills = Arrays.asList("java", "golang", "c++", "c", "python");
        String s = skills.stream().reduce((all, skill) -> all + skill).get();
        System.out.println(s);
    }

    /**
     * filter 过滤测试
     */
    @Test
    public void filterTest() {
        List<String> skills = Arrays.asList("java", "golang", "c++", "c", "python");
        List<String> strings = skills.stream().filter(skill -> skill.length() > 4).collect(Collectors.toList());
        strings.forEach(skill -> System.out.println(skill));
    }

    /**
     * 数据去重测试
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
