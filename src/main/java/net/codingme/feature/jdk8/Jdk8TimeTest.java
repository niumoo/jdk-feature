package net.codingme.feature.jdk8;

import org.junit.Test;

import java.security.MessageDigest;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * <p>
 * JDK 8 date / time api
 * <p>
 * 优点： <br/>
 * - 都是final 不可变类，适用于多线程 <br/>
 * - 用法清晰，如都适用的now(),of(),parse(),format()方法<br/>
 * - 实现了大部分常用操作方法
 * </p>
 *
 * @Author niujinpeng
 * @Date 2019/2/19 17:48
 */
public class Jdk8TimeTest {

    /**
     * 时间获取和创建
     */
    @Test
    public void nowTimeTest() {
        // 当前详细时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth() + " " + now.getHour() + "-" + now.getMinute() + "-" + now.getSecond());

        // 获取当前日期
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getYear() + "-" + localDate.getMonthValue() + "-" + localDate.getDayOfMonth());

        // 获取当前时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond());
    }

    /**
     * 时间创建
     */
    @Test
    public void createTime() {
        LocalDateTime ofTime = LocalDateTime.of(2019, 2, 1, 8, 8, 8);
        System.out.println(ofTime);

        LocalTime localTime = LocalTime.of(12, 01, 01);
        System.out.println(localTime);

        LocalDate localDate = LocalDate.of(2019, 01, 01);
        System.out.println(localDate);

        LocalDateTime parseTime = LocalDateTime.parse("2019-02-02T22:22:22.222");
        System.out.println(parseTime);

        LocalDate formatted = LocalDate.parse("20190101", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("时间转换：" + formatted);

        Date date = new Date();
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("时间转换2："+LocalDateTime.ofInstant(date.toInstant(),zoneId));
    }

    /**
     * 日期格式化
     */
    @Test
    public void formatTest() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间：" + now);
        System.out.println("格式化后：" + now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("格式化后：" + now.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("格式化后：" + now.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println("格式化后：" + now.format(DateTimeFormatter.ofPattern("YYYY-MM-dd hh:mm:ss")));
    }

    /**
     * 时间比较
     */
    @Test
    public void diffTest() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yestory = now.minusDays(1);
        System.out.println(now + "在" + yestory + "之后吗?" + now.isAfter(yestory));
        System.out.println(now + "在" + yestory + "之前吗?" + now.isBefore(yestory));

        // 时间差
        long day = yestory.until(now, ChronoUnit.DAYS);
        long month = yestory.until(now, ChronoUnit.MONTHS);
        long hours = yestory.until(now, ChronoUnit.HOURS);
        long minutes = yestory.until(now, ChronoUnit.MINUTES);
        System.out.println("相差月份" + month);
        System.out.println("相差天数" + day);
        System.out.println("相差小时" + hours);
        System.out.println("相差分钟" + minutes);
    }

    /**
     * 时间方法
     */
    @Test
    public void timeFunctionTest() {
        LocalDateTime now = LocalDateTime.now();
        // 第一天
        LocalDateTime firstDay = now.withDayOfMonth(1);
        System.out.println(firstDay);
        // 当天最后一秒
        LocalDateTime lastSecondOfDay = now.withHour(23).withMinute(59).withSecond(59);
        System.out.println(lastSecondOfDay);
        // 最后一天
        LocalDateTime lastDay = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);
        // 是否闰年
        System.out.println("今年是否闰年" + Year.isLeap(now.getYear()));

    }

    /**
     * 日期加减
     */
    @Test
    public void calcTest() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime plusTime = now.plusMonths(1).plusDays(1).plusHours(1).plusMinutes(1).plusSeconds(1);
        System.out.println("增加时间后：" + plusTime);
        LocalDateTime minusTime = now.minusMonths(2);
        System.out.println("减少时间后：" + minusTime);
    }

}
