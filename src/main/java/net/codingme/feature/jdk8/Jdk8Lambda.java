package net.codingme.feature.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 * Lambda 表达式
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
public class Jdk8Lambda {

    private static List<User> userList = new ArrayList<User>();

    @Before
    public void before() {
        userList.add(new User("A", 26));
        userList.add(new User("B", 18));
        userList.add(new User("C", 23));
        userList.add(new User("D", 19));
    }

    /**
     * jdk 1.8 之前排序输出
     */
    @Test
    public void testSortBeforeJdk8() {
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getAge() - u2.getAge();
            }
        });
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * jdk 1.8 之后排序输出
     */
    @Test
    public void testSortAfterJdk8() {
        // 方式1
        userList.sort((User u1, User u2) -> u1.getAge() - u2.getAge());
        userList.forEach(user -> System.out.println(user));
        System.out.println("------------------------");
        // 方式2
        userList.sort((u1, u2) -> u1.getAge().compareTo(u2.getAge()));
        userList.forEach(System.out::println);
        System.out.println("------------------------");
        // 方式3
        userList.sort(Comparator.comparing(User::getAge));
        userList.forEach(System.out::println);
        System.out.println("------------------------");
        // 方式4
        userList.stream().sorted(Comparator.comparing(User::getAge)).forEach(System.out::println);
    }

    /**
     * 使用 ()->{} 代替匿名内部类
     * 
     */
    @Test
    public void runnableTest() {
        // jdk8 之前
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("before jdk8 runnable start ...");
            }
        }).start();

        // jdk8 之后
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
        // 方式1
        skills.forEach((skill) -> System.out.println(skill));
        System.out.println("------------------------");
        // 方式2
        skills.forEach(System.out::println);
    }

}

@Data
@AllArgsConstructor
class User {
    private String name;
    private Integer age;
}
