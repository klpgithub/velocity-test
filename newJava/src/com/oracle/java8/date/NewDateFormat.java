package com.oracle.java8.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.junit.Test;

public class NewDateFormat {

    @Test
    public void testDateFormat() {
        DateTimeFormatter[] formatters = new DateTimeFormatter[] {
                // // 直接使用常量创建DateTimeFormatter格式器
                DateTimeFormatter.ISO_LOCAL_DATE, //
                DateTimeFormatter.ISO_LOCAL_TIME, //
                DateTimeFormatter.ISO_LOCAL_DATE_TIME, //
                // 使用本地化的不同风格来创建DateTimeFormatter格式器
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM), //
                DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG), //
                // 根据模式字符串来创建DateTimeFormatter格式器
                DateTimeFormatter.ofPattern("Gyyyy-MMM-dd HH:mm:ss") };

        LocalDateTime localDateTime = LocalDateTime.now();
        for (int i = 0; i < formatters.length; i++) {
            // System.out.println(localDateTime.format(formatters[i]));
            System.out.println(formatters[i].format(localDateTime));
        }
    }

    @Test
    public void testString2Date() {
        // 定义一个任意格式的日期时间字符串
        String str1 = "2014==04==12 01时06分09秒";
        // 根据需要解析的日期、时间字符串定义解析所用的格式器
        DateTimeFormatter fomatter1 = DateTimeFormatter.ofPattern("yyyy==MM==dd HH时mm分ss秒");
        // 执行解析
        LocalDateTime dt1 = LocalDateTime.parse(str1, fomatter1);
        System.out.println(dt1); // 输出 2014-04-12T01:06:09
        // ---下面代码再次解析另一个字符串---
        String str2 = "2014$$$四月$$$13 20小时";
        DateTimeFormatter fomatter2 = DateTimeFormatter.ofPattern("yyy$$$MMM$$$dd HH小时");
        LocalDateTime dt2 = LocalDateTime.parse(str2, fomatter2);
        System.out.println(dt2); // 输出 2014-04-13T20:00
        
        String string = "2019-09-09 23:59:59";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(string, formatter);
        System.out.println(dateTime.toLocalDate()+" "+dateTime.toLocalTime());
    }

}
