package com.oracle.java8.date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

public class LocalDateTimeTest {

    @Test
    public void testLocalDate() {
        LocalDate today = LocalDate.now();
        LocalDate f = LocalDate.of(2018, 11, 20);
        LocalDate parse = LocalDate.parse("2016-02-20");
        // 取本月第1天：
        LocalDate date = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(date);
        System.out.println(today.withDayOfMonth(2));
        // 取本月最后一天，再也不用计算是28，29，30还是31：
        System.out.println(today.with(TemporalAdjusters.lastDayOfMonth()));
        // 获取下一天
        System.out.println(today.plusDays(1));
        // 获取本月第一个周一
        System.out.println(today.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
    }

    @Test
    public void testLocalTime() {
        LocalTime time = LocalTime.now();// 16:14:45.276
        System.out.println(time.withNano(0));// 16:16:21 去掉毫秒值

        LocalTime.of(0, 0, 0);
        LocalTime.parse("12:00:00");
    }

    @Test
    public void testLocalDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();// 2017-04-10T16:33:59.960
        System.out.println(dateTime.getMonth().length(true));
        System.out.println(dateTime.getMonth().name());
        System.out.println(dateTime);
        System.out.println(dateTime.plus(Duration.ofHours(2)));
        System.out.println(dateTime.plus(Period.ofDays(3)));
        System.out.println(dateTime.minus(Duration.ofDays(4)));
        System.out.println(dateTime.plus(1, ChronoUnit.CENTURIES));
    }

    @Test
    public void testConstant() {
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIDNIGHT);
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.NOON);
    }

}
