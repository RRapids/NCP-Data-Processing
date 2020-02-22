package com.soft1851.ncp.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author tf_yuan
 * @description TODO
 * @date 2020/2/21
 */
public class DataBaseConnection {

    private String DBDRIVER = "com.mysql.jdbc.Driver";
    private String DBURL = "jdbc:mysql://localhost:3306/NCP_data_processing?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
    private String DBUSER = "root";
    private String DBPASSWORD = "root";
    private Connection conn = null;

    public DataBaseConnection() {
        try {
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        } catch (Exception e) {
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void close() {
        try {
            this.conn.close();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        System.out.println("OK");
    }
}
