package net.codingme.feature.jdk7.io;

import java.io.ByteArrayInputStream;

public class ByteInputStream {

    public static void main(String[] args) {
        byte[] chars = "WeiDuDaiMa".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(chars);
        // 可以读取的数量
        System.out.println(inputStream.available());

        // 流的读取
        int read = -1;
        while ((read = inputStream.read()) != -1) {
            System.out.print((char)read);
        }
        System.out.println();

        // 流的标记
        inputStream = new ByteArrayInputStream(chars);
        System.out.print((char) inputStream.read());
        System.out.print((char) inputStream.read());
        // 标记当前位置
        inputStream.mark(1);
        System.out.print((char) inputStream.read());
        System.out.println((char) inputStream.read());
        inputStream.reset();
        while ((read = inputStream.read()) != -1) {
            System.out.print((char)read);
        }
    }
}
