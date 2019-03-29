package net.codingme.feature.jdk8;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * 使用 Lambda 根据 List中某个属性排序
 *
 * @Author niujinpeng
 * @Date 2019/3/29 11:10
 */
public class Jdk8LambdaSortListTest {


    @Test
    public void testSort() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("A", 26));
        userList.add(new User("B", 18));
        userList.add(new User("C", 23));
        userList.add(new User("D", 19));
        // before jdk 1.8
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

    @Test
    public void testSortByLambda() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("A", 26));
        userList.add(new User("B", 18));
        userList.add(new User("C", 23));
        userList.add(new User("D", 19));

        // after jdk 1.8
        userList.sort((User u1, User u2) -> u1.getAge() - u2.getAge());
        userList.forEach(user -> System.out.println(user));
    }
}

class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}