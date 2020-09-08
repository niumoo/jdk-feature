package net.codingme.feature.jdk7;

/**
 * 自动关闭
 *
 * @author www.codingme.net
 */
public class AutoCloseResource {
    public static void main(String[] args) throws Exception {
        try (Mysql mysql = new Mysql();
            OracleDatabase oracleDatabase = new OracleDatabase()) {
            mysql.conn();
            oracleDatabase.conn();
        }
    }
}

class Mysql implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("mysql 已关闭");
    }

    public void conn() {
        System.out.println("mysql 已连接");
    }
}

class OracleDatabase implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("OracleDatabase 已关闭");
    }

    public void conn() {
        System.out.println("OracleDatabase 已连接");
    }
}
