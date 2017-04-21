package com.oracle.java7.resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class ChannelMapTest {

    @Test
    public void testChannel() {
        File file = new File("D:/2/bj/app2.js");
        try (FileChannel channel = new RandomAccessFile(file, "rwd").getChannel()) {
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, file.length());
            buffer.put("二狗子二狗子二狗子！！！！！！！！！！！！！！！！！".getBytes());
            channel.position(file.length());
            buffer.clear();
            channel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
