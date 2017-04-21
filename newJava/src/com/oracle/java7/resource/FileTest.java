package com.oracle.java7.resource;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileTest {

    public static void main(String[] args) throws IOException {

        // Path p1 = Paths.get("D:/aa/aa.txt");
        // Files.createFile(p1);
        // Path p2 = Paths.get("D:/aa/bb.lll");
        // // Files.createFile(p2);
        //
        // Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
        //
        // boolean b = Files.deleteIfExists(p1);
        //// System.out.println(b);

        List<String> list = Files.readAllLines(
                Paths.get("C:/tt/tt/企业一套表统计调查制度(2014)/520100000000_20170221151008/V_8600000002014070707000001.csv"),
                Charset.forName("GBK"));
        System.out.println(list.size());

        System.out.println(File.pathSeparator);  
        System.out.println(File.separator);
        
    }

}
