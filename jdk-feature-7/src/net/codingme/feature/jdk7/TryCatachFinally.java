package net.codingme.feature.jdk7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 释放资源
 *
 * @author www.codingme.net
 */
public class TryCatachFinally {

    /**
     * 异常处理
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("jdk-feature-7.iml");
        } catch (FileNotFoundException e) {
            throw e;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw e;
                }
            }
        }
    }
}
