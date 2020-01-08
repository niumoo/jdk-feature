package net.codingme.feature.jdk7;

import java.io.IOException;

/**
 * 多异常捕获
 */
public class TryCatchMany {

    public static void main(String[] args) {
        try (TxtRead txtRead = new TxtRead()) {
            txtRead.reader();
        } catch (IOException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TxtRead implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("资源释放");
    }

    public void reader() throws IOException, NoSuchFieldException {
        System.out.println("数据读取");
    }
}
