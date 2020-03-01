package net.codingme.feature.jdk11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/2/29 21:44
 */
public class Java11File {
    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException {
        // 创建临时文件
        Path path = Files.writeString(Files.createTempFile("test", ".txt"), "This was posted on JD");
        System.out.println(path);
        // 读取文件
        String s = Files.readString(path);
        String ss = Files.readString(Path.of("file.json"));
        System.out.println(ss);
        System.out.println(s); // This was posted on JD

    }
}
