package net.codingme.feature.jdk8;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <p>
 * JDK 8 steam 流操作
 *
 * @Author niujinpeng
 * @Date 2019/8/12 18:03
 */
public class Jdk8Stream {

    /**
     * 创建流的几种方式
     * 集合
     * Collection.stream();
     * Collection.parallelStream()
     * 数组
     * Arrays.stream(T array) or Stream.of()
     * 文件流
     * java.io.BufferedReader.lines()
     * 静态方法
     * IntStream.range，IntStream.of
     */
    @Test
    public void createStream() throws FileNotFoundException {
        List<String> nameList = Arrays.asList("Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter");
        String[] nameArr = {"Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter"};
        // 集合获取 Stream 流
        Stream<String> nameListStream = nameList.stream();
        // 集合获取并行 Stream 流
        Stream<String> nameListStream2 = nameList.parallelStream();
        // 数组获取 Stream 流
        Stream<String> nameArrStream = Stream.of(nameArr);
        // 数组获取 Stream 流
        Stream<String> nameArrStream1 = Arrays.stream(nameArr);

        // 文件流获取 Stream 流
        BufferedReader bufferedReader = new BufferedReader(new FileReader("README.md"));
        Stream<String> linesStream = bufferedReader.lines();

        // 从静态方法获取流操作
        IntStream rangeStream = IntStream.range(1, 10);
        rangeStream.limit(10).forEach(num -> System.out.print(num+","));
        System.out.println();
        IntStream intStream = IntStream.of(1, 2, 3, 3, 4);
        intStream.forEach(num -> System.out.print(num+","));
    }

    @Test
    public void streamDemo(){
        List<String> nameList = Arrays.asList("Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter");
        // 1. 筛选出名字长度为4的
        // 2. 名字前面拼接 This is
        // 3. 遍历输出
        nameList.stream()
                .filter(name -> name.length() == 4)
                .map(name -> "This is "+name)
                .forEach(name -> System.out.println(name));
    }

    /**
     * 转换成为大写然后收集结果，遍历输出
     */
    @Test
    public void toUpperCaseDemo() {
        List<String> nameList = Arrays.asList("Darcy", "Chris", "Linda", "Sid", "Kim", "Jack", "Poul", "Peter");
        List<String> upperCaseNameList = nameList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        upperCaseNameList.forEach(name -> System.out.print(name + ","));
    }

    /**
     * 把数字值乘以2
     */
    @Test
    public void mapTest() {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> collect = numberList.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());
        collect.forEach(number -> System.out.print(number + ","));
    }


    /**
     * flatmap把对象扁平化
     */
    @Test
    public void flatMapTest() {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        List<Integer> collect = inputStream
                .flatMap((childList) -> childList.stream())
                .collect(Collectors.toList());
        collect.forEach(number -> System.out.print(number + ","));
    }

    /**
     * 遍历输出
     */
    @Test
    public void forEachTest(){
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numberList.stream().forEach(number -> System.out.print(number+","));
    }

    /**
     * filter 数据筛选
     * 筛选出偶数数字
     */
    @Test
    public void filterTest() {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> collect = numberList.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        collect.forEach(number -> System.out.print(number + ","));
    }

    /**
     * 查找第一个数据
     * 返回的是一个 Optional 对象
     */
    @Test
    public void findFirstTest(){
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> firstNumber = numberList.stream()
                .findFirst();
        System.out.println(firstNumber.orElse(-1));
    }


    @Test
    public void test1() {

        // 不适用流操作
        List<String> names = Arrays.asList("Jack", "Jill", "Nate", "Kara", "Kim", "Jullie", "Paul", "Peter");

        // 筛选出长度为4的值
        List<String> subList = new ArrayList<>();
        for (String name : names) {
            if (name.length() == 4) {
                subList.add(name);
            }
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
        String str = names.stream().filter(num -> num.length() == 4).collect(Collectors.joining(", "));
        System.out.println(str);
    }

    /**
     * map，注意，这里的map是进行1:1的转换映射，一般用于从前到后的内容和类型修改
     */
    @Test
    public void mapTest2() {
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
    public void filterTest2() {
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
