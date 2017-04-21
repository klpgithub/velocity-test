package com.oracle.java7.resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class NIO2FileAndDir {

    public static void main(String[] args) throws Exception {

        Path path = FileSystems.getDefault().getPath("aa.txt");

        boolean file_exists = Files.exists(path, new LinkOption[] { LinkOption.NOFOLLOW_LINKS });
        boolean file_notExists = Files.notExists(path, LinkOption.NOFOLLOW_LINKS);
        System.out.println(file_exists);
        System.out.println(file_notExists);

        System.out.println(Files.isReadable(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isExecutable(path));
        System.out.println(Files.isRegularFile(path, LinkOption.NOFOLLOW_LINKS));

        System.out.println(Files.isHidden(path));

        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();
        for (Path name : rootDirectories) {
            System.out.println(name);
        }

        /**
         * 1.6
         */
        // File[] listRoots = File.listRoots();
        // for (File file : listRoots) {
        // System.out.println(file);
        // }

        // 创建新目录
        Path newdir = FileSystems.getDefault().getPath("C:/tt/aaa");
        // try {
        // Files.createDirectory(newdir);
        // } catch (IOException e) {
        // System.err.println(e);
        // }
//        Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-x---");
//        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
        try {
            Files.createDirectory(newdir);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
