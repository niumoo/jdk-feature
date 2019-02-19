package net.codingme.feature.jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 方法引用，通过方法的名字指向一个方法
 *
 * @Author niujinpeng
 * @Date 2019/2/18 22:08
 */
public class Jdk8FunctionTest {

    public static void main(String[] args) {
        // 构造器引用
        final Car bmwCar = Car.create(Car::new);
        bmwCar.setName("BMW");
        final Car audiCar = Car.create(Car::new);
        audiCar.setName("AUDI");
        List<Car> cars = Arrays.asList(bmwCar, audiCar);

        // 静态方法引用
        cars.forEach(Car::collide);

        // 特定类的任意对象的方法引用
        cars.forEach(Car::repair);

        // 特定对象的方法引用
        cars.forEach(bmwCar::follow);

    }

}

class Car {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collied:" + car.getName());
    }

    public void follow(final Car another) {
        System.out.println("Following the:" + another.getName());
    }

    public void repair() {
        System.out.println("Repaired:" + this.getName());
    }

}

@FunctionalInterface
interface Supplier<T> {
    /**
     * 获取元素
     * @return
     */
    T get();
}