package com.oracle.java7.resource;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SeekChannel {

    public static void main(String[] args) throws IOException {

        FileChannel fileChannel = FileChannel.open(Paths.get("aa.txt"), StandardOpenOption.WRITE,
                StandardOpenOption.READ, StandardOpenOption.CREATE);

        fileChannel.write(ByteBuffer.wrap("hello,java".getBytes()));
        fileChannel.position(0);// 定位到文件开头
        fileChannel.write(ByteBuffer.wrap("seek".getBytes()));
        fileChannel.position(fileChannel.size());// 定位到文件末尾
        fileChannel.write(ByteBuffer.wrap("end".getBytes()));

        // 将通道中的指定位置开始的内容传输到另一个通道中，这里传输到控制台
        fileChannel.transferTo(1, fileChannel.size(), Channels.newChannel(System.out));

    }

}
