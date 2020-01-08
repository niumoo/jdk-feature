package net.codingme.feature.jdk7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 变长参数
 */
public class AutoParams {

    public static void main(String[] args) {
        // 求和
        System.out.println(sum(1, 2, 3, 4, 5, 6, 7));
        // 获取数组
        Integer[] intArray = getArray(1, 2, 3, 4);
        String[] stringArray = getArray("a", "b", "c");
        System.out.println(intArray[0]);
        System.out.println(stringArray[0]);
    }

    /**
     * 通过可变参数求和
     *
     * @param args
     * @return
     */
    public static int sum(int... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    public static <T> T[] getArray(T... args) {
        return args;
    }
    
}
