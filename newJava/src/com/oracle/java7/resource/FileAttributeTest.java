package com.oracle.java7.resource;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class FileAttributeTest {

    @Test
    public void TESTAttribute() throws IOException {

        Path path = Paths.get("aa.txt");

        BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes basicFileAttributes = basicFileAttributeView.readAttributes();
        System.out.println("创建时间：" + new Date(basicFileAttributes.creationTime().toMillis()));

        DosFileAttributeView dosFileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        dosFileAttributeView.setHidden(false);

        UserDefinedFileAttributeView userDefinedFileAttributeView = Files.getFileAttributeView(path,
                UserDefinedFileAttributeView.class);
        userDefinedFileAttributeView.write("版权人", Charset.defaultCharset().encode("二狗子"));

        List<String> list = userDefinedFileAttributeView.list();// 准备一块儿内存块读取
        for (String name : list) {
            ByteBuffer buffer = ByteBuffer.allocate(userDefinedFileAttributeView.size(name));// 准备一块儿内存块读取
            userDefinedFileAttributeView.read(name, buffer);
            buffer.flip();
            String value = Charset.defaultCharset().decode(buffer).toString();
            System.out.println(name + ":" + value);
        }
    }
}
