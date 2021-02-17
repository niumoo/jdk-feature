package com.wdbyte.feature.jdk12;

import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.Locale;

/**
 * 数字格式化
 * @author darcy
 * @date 2021/02/17
 */
public class NumberFormatting {

    public static void main(String[] args) {
        System.out.println("Compact Formatting is:");
        NumberFormat upvotes = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), Style.SHORT);

        System.out.println(upvotes.format(100));
        System.out.println(upvotes.format(1000));
        System.out.println(upvotes.format(10000));
        System.out.println(upvotes.format(100000));
        System.out.println(upvotes.format(1000000));

        // 设置小数位数
        upvotes.setMaximumFractionDigits(1);
        System.out.println(upvotes.format(1234));
        System.out.println(upvotes.format(123456));
        System.out.println(upvotes.format(12345678));
    }
}
