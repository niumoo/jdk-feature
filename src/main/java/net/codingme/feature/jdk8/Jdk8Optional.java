package net.codingme.feature.jdk8;

import lombok.*;

import java.nio.charset.Charset;
import java.util.Optional;

/**
 * <p>
 * JDK8 为解决空指针增加的 Optional 方法
 * 
 * @Author niujinpeng
 * @Date 2019/2/19 11:40
 */
public class Jdk8Optional {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("WangCai");
        dog.setAge(1);
        // option 三种构造方式 - of 不能为 null
        Optional<Dog> dogOptional = Optional.of(dog);
        // option 三种构造方式 - empty 一个空 optional
        Optional<Dog> emptyOptional = Optional.empty();
        // option 三种构造方式 - ofNullable 允许所有
        Optional<Dog> nullOptional = Optional.ofNullable(null);

        System.out.println(dogOptional.orElse(null));
        System.out.println(emptyOptional.orElse(null));
        System.out.println(nullOptional.orElse(null));
        System.out.println("------------------------------------------");

        // 存在则直接返回，不存在则新建
        Dog orElseGetDog = dogOptional.orElseGet(() -> new Dog());
        System.out.println(orElseGetDog);

        Dog orElseGetDog2 = emptyOptional.orElseGet(() -> new Dog());
        System.out.println(orElseGetDog2);

        Dog orElseGetDog3 = nullOptional.orElseGet(() -> new Dog());
        System.out.println(orElseGetDog3);
        System.out.println("------------------------------------------");

        // 存在则输出
        dogOptional.ifPresent(Dog::toString);
        // before jdk8
        if (dog != null) {
            dog.toString();
        }
        System.out.println("------------------------------------------");

        // 存在则获取，不存在则默认
        String dogName = dogOptional.map(d -> d.getName()).orElse("undefine");
        System.out.println(dogName);
        String dogName2 = nullOptional.map(d -> d.getName()).orElse("undefine");
        System.out.println(dogName2);
        // before
        // if (dog != null && dog.getName() != null) {
        // System.out.println(dog.getName());
        // } else {
        // System.out.println("undefine");
        // }
        System.out.println("------------------------------------------");

        // 数据处理
        String dogName3 = dogOptional.map(d -> d.getName().toUpperCase()).orElse(null);
        System.out.println(dogName3);
        String dogName4 = nullOptional.map(d -> d.getName().toUpperCase()).orElse(null);
        System.out.println(dogName4);
        System.out.println("------------------------------------------");

        // 异常处理
        Dog dogThrow1 = dogOptional.orElseThrow(() -> new RuntimeException("dog is empty"));
        System.out.println(dogThrow1);
        Dog dogThrow2 = emptyOptional.orElseThrow(() -> new RuntimeException("dog is empty"));
        System.out.println(dogThrow2);

    }
}

@Data
class Dog {
    private String name;
    private Integer age;
}
