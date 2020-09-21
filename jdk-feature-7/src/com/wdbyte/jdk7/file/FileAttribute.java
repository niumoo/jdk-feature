package com.wdbyte.jdk7.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.UserPrincipal;

/**
 * 文件属性
 *
 * @author darcy
 * @date 2020/09/07
 */
public class FileAttribute {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/darcy/git/jdk-feature/README.md");
        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes basicFileAttributes = fileAttributeView.readAttributes();
        FileTime creationTime = basicFileAttributes.creationTime();
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();
        System.out.println("创建时间：" + creationTime);
        System.out.println("上次修改时间：" + lastModifiedTime);
        System.out.println("上次访问时间：" + lastAccessTime);

        boolean directory = basicFileAttributes.isDirectory();
        boolean regularFile = basicFileAttributes.isRegularFile();
        boolean symbolicLink = basicFileAttributes.isSymbolicLink();
        System.out.println("是否目录：" + directory);
        System.out.println("是否普通文件：" + regularFile);
        System.out.println("是否符号链接：" + symbolicLink);

        long size = basicFileAttributes.size();
        System.out.println("文件大小：" + size);

        PosixFileAttributeView linuxFileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
        UserPrincipal owner = linuxFileAttributeView.getOwner();
        System.out.println("文件归属用户:" + owner.getName());

    }
}
