package net.codingme.feature.jdk7;

import java.io.IOException;

/**
 * 释放资源
 *
 * @author www.codingme.net
 */
public class TryCatachFinallyThrow {

    public static void main(String[] args) throws Exception {
        read();
    }

    public static void read() throws Exception {
        FileRead fileRead = null;
        try {
            fileRead = new FileRead();
            fileRead.read();
        } catch (Exception e) {
            throw e;
        } finally {
            if (fileRead != null) {
                try {
                    fileRead.close();
                } catch (Exception e) {
                    throw e;
                }
            }
        }

    }
}

class FileRead {

    public void read() throws Exception {
        throw new IOException("读取异常");
    }

    public void close() throws Exception {
        System.out.println("资源关闭");
        throw new IOException("关闭异常");
    }
}