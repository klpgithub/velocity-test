package com.oracle.java7.resource;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FilesTest {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("D:/");

        // DirectoryStream<Path> stream = Files.newDirectoryStream(path);
        // for(Path item : stream){
        // System.out.println(item.toAbsolutePath()+":"+item.getFileName());
        // }

        DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.zip");
        for (Path p : stream) {
            System.out.println("----------------------------" + p.getFileName());
        }

        /**
         * jdk1.7以后迭代目录。。。。。
         */
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            /**
             * 访问文件前的操作
             */
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                // System.out.println("正在访问："+dir);
                return FileVisitResult.CONTINUE;
            }

            /**
             * 文件被访问时被调用。该文件的文件属性被传递给这个方法
             */
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // System.out.println("正在访问" + file + "文件");
                if (file.endsWith("search.bat")) {
                    System.out.println("找到目标文件");
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }

            /**
             * 当文件不能被访问时，此方法被调用。Exception被传递给这个方法。
             */
            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("visitFileFailed : " + file.getFileName());
                return FileVisitResult.CONTINUE;
            }

            /**
             * 一个路径的所有节点被访问后调用。如果有错误发生，exception会传递给这个方法
             */
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return super.postVisitDirectory(dir, exc);
            }

        });
    }
}
