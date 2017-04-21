package com.oracle.java7.resource;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StreamFileTest {
    
    @Test
    public void testStream() throws IOException{
        Path path = Paths.get("D:/2/bj/app.js");
        
//        DirectoryStream<Path> stream = Files.newDirectoryStream(path.toAbsolutePath(), "*.java");
//        for (Path p : stream) {
//            System.out.println(p.getFileName());
//        }
//        Files.list(path).forEach(a -> System.out.println(a.getFileName()));
        List<String> list = new ArrayList<>();
        Files.lines(path.toAbsolutePath()).forEach(b->{
            list.add(b);
        });
        System.out.println(list.size());
    }
    
    @Test
    public void testFileStore() throws IOException{
        FileStore store = Files.getFileStore(Paths.get("D:/"));
        System.out.println(store.getTotalSpace());
        System.out.println(store.getUsableSpace());
    }
    
}
