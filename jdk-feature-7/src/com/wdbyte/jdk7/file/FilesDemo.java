package com.wdbyte.jdk7.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Files 类的使用
 *
 * @author darcy
 * @date 2020/09/07
 */
public class FilesDemo {

    public static void main(String[] args) throws IOException {
        // 如果文件不存在，则创建一个文件
        Path path = Paths.get("test.txt");
        Path pathBackup = Paths.get("test_bak.txt");
        Path pathLink = Paths.get("test.txt.link");
        Path pathDir = Paths.get("dir");

        // 已存在则删除
        Files.deleteIfExists(path);
        Files.deleteIfExists(pathBackup);
        Files.deleteIfExists(pathLink);
        Files.deleteIfExists(pathDir);

        // 创建文件写入内容
        Path file = Files.createFile(path);
        Files.write(path, "关注公众号：未读代码".getBytes());
        Files.write(path, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
        Files.write(path, "欢迎加我微信：wn8398".getBytes(), StandardOpenOption.APPEND);
        System.out.println("创建文件：" + file.toString());

        // 创建文件链接
        pathLink = Files.createLink(pathLink, path);
        System.out.println("创建文件：" + pathLink.toString());

        // 创建目录
        Path directory = Files.createDirectory(pathDir);
        System.out.println("创建目录：" + directory.toString());

        // 文件复制
        Files.copy(path, pathBackup);
        System.out.println("复制文件: " + path + " --> " + pathBackup);

        // 读取文件
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            System.out.println("文件读取：" + line);
        }
    }
}
