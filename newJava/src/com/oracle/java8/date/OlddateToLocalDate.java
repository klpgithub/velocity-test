package com.oracle.java8.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;

public class OlddateToLocalDate {
    
    /**
     * java.util.Date --> java.time.LocalDateTime
     */
    @Test
    public void test1(){
        Date date = new Date();
        System.out.println(date);
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, zoneId);
        
        System.out.println(dateTime);
    }
       
    @Test
    public void test2(){
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.toLocalDate();
        localDateTime.toLocalTime();
    }
    
    /**
     * java.time.LocalDateTime --> java.util.Date
     */
    @Test
    public void test3(){
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        Date date = Date.from(instant);
        
    }
    
    /**
     * 05. java.time.LocalDate --> java.util.Date
     */
    @Test
    public void Test4(){
        LocalDate localDate = LocalDate.now();
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay(zoneId).toInstant();
        Date date = Date.from(instant);
    }
    
    /**
     * 06. java.time.LocalTime --> java.util.Date
     */
    @Test
    public void test5(){
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        Date.from(instant);
    }
}
