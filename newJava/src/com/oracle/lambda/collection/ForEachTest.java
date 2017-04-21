package com.oracle.lambda.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachTest {

    public static void main1(String[] args) {

        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
        // jdk1.7以前遍历map
        // for (Map.Entry<String, Integer> entry : items.entrySet()) {
        // System.out.println("item:" + entry.getKey() + "\t count : " +
        // entry.getValue());
        // }

        // jdk 1.8
        items.forEach((k, v) -> System.out.println("item : " + k + "\t count : " + v));

        items.forEach((k, v) -> {
            if ("E".equals(k)) {
                System.out.println("Hello \t\t\t\t\t  E");
            }
        });
    }
    
    public static void main(String[] args) {
        
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");
        
        items.forEach(item -> System.out.println(item));
        
        items.forEach(System.out::println);
        
        items.forEach(item -> {
            if ("C".equals(item)) {
                System.out.println("\t\t\t"+item);
            }
        });
        items.stream().filter(s -> s.contains("B")).forEach(System.out::printf);
        
        StringBuilder sb = new StringBuilder('a');
        System.out.println(sb+"99999999999999999999");
        System.out.println(sb.capacity());
    }
    
}
