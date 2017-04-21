package com.oracle.java7.resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TryWithResource {

    public static void main(String[] args) {
        beforeJava7();
        newJava7();

        int aa = 100_00_00;// 3.数字字面量下划线支持
        System.out.println(Integer.MAX_VALUE);
        // 5.二进制字面量
        int binary = 0b01010101;
        System.out.println(binary);
        byte aByte = (byte) 0b001; // 将二进制字符转换为数据类型，如在byte或short    
    }

    /**
     * 1.自动资源管理(TWR)--try with resource
     * Java中某些资源是需要手动关闭的，如InputStream，Writes，Sockets，Sql classes等。
     * 这个新的语言特性允许try语句本身申请更多的资源，这些资源作用于try代码块，并自动关闭。
     */
    private static void newJava7() {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:/tt/tt/企业一套表统计调查制度(2014)/520100000000_20170221151008/V_8600000002014070707000001.csv"))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

    private static void beforeJava7() {
        BufferedReader br = null;
        List<String> list = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(
                    "C:/tt/tt/企业一套表统计调查制度(2014)/520100000000_20170221151008/V_8600000002014070707000001.csv"));
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(list.size());
    }

}
