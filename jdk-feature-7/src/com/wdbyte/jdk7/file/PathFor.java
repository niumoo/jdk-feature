package com.wdbyte.jdk7.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author darcy
 * @date 2020/09/07
 */
public class PathFor {

    public static void main(String[] args) throws IOException {
        // 文件直接遍历，不会遍历子目录
        String pathString = "/Users/darcy/project/mylab/src/main/java/com/wdbyte/java";
        File file = new File(pathString);
        File[] listFiles = file.listFiles();
        for (File tempFile : listFiles) {
            System.out.println("file list: " + tempFile.getAbsolutePath());
        }
        System.out.println("-------------------------------------ListFiles");

        // Path 直接遍历方式，不会遍历子目录
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(pathString))) {
            for (Path pathTemp : directoryStream) {
                System.out.println("DirectoryStream: " + pathTemp);
            }
        }
        System.out.println("-------------------------------------DirectoryStream");

        // Path 直接遍历方式 - 筛选 .class 文件
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(pathString), "*.java")) {
            for (Path pathTemp : directoryStream) {
                System.out.println("DirectoryStream file type is class : " + pathTemp);
            }
        }
        System.out.println("-------------------------------------DirectoryStream Filter");

        // 遍历所有目录和子目录
        Stream<Path> pathStream = Files.walk(Paths.get("/Users/darcy/project/mylab/src/main/java/com/wdbyte"));
        pathStream.forEach(pathTemp -> {
            System.out.println("Stream: " + pathTemp.toString());
        });
        System.out.println("-------------------------------------Stream path");

        // 遍历所有目录和子目录 - 筛选 java 文件
        pathStream = Files.walk(Paths.get("/Users/darcy/project/mylab/src/main/java/com/wdbyte"));
        pathStream
            .filter(pathTemp -> pathTemp.toString().endsWith(".java"))
            .forEach(pathTemp -> {
                System.out.println("Stream filter java: " + pathTemp.toString());
            });
        System.out.println("-------------------------------------Stream path filter");
    }
}
