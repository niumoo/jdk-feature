package com.wdbyte.feature.jdk12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 文件对比
 * @author darcy
 * @date 2021/02/17
 */
public class FileMismatch {

    public static void main(String[] args) throws IOException {

        // 创建两个文件
        Path pathA = Files.createFile(Paths.get("a.txt"));
        Path pathB = Files.createFile(Paths.get("b.txt"));

        // 写入相同内容
        Files.write(pathA,"abc".getBytes(), StandardOpenOption.WRITE);
        Files.write(pathB,"abc".getBytes(), StandardOpenOption.WRITE);
        long mismatch = Files.mismatch(pathA, pathB);
        System.out.println(mismatch);

        // 追加不同内容
        Files.write(pathA,"123".getBytes(), StandardOpenOption.APPEND);
        Files.write(pathB,"321".getBytes(), StandardOpenOption.APPEND);
        mismatch = Files.mismatch(pathA, pathB);
        System.out.println(mismatch);

        // 删除创建的文件
        pathA.toFile().deleteOnExit();
        pathB.toFile().deleteOnExit();
    }
}
