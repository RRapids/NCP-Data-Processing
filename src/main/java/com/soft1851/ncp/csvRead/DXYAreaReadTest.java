package com.soft1851.ncp.csvRead;

import com.soft1851.ncp.until.DataBaseConnection;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author tf_yuan
 * @description TODO
 * @date 2020/2/20
 */

public class DXYAreaReadTest {

    public static void main(String[] args) throws FileNotFoundException, SQLException {
        long startTime = System.currentTimeMillis();
        File file = new File("D:\\javastudy\\project\\NCP-Data-Processing\\src\\main\\resources\\data\\DXYArea.csv");
        System.out.println("开始导入数据");
        Scanner in = new Scanner(file);
        insert_data(in);
        long EndTime = System.currentTimeMillis();
        long time = (EndTime - startTime) / 1000;
        System.out.println("导入地区数据（DXYArea.csv）共用时：" + time+"s");
    }

    private static void insert_data(Scanner in) throws SQLException {
        String sql = "insert into area (province_name,province_englishName,province_ZipCode,city_name,city_englishName," +
                "city_ZipCode,province_confirmedCount,province_suspectedCount,province_cureCount,province_deadCount," +
                "city_firmedCount,city_suspectCount,city_cureCount,city_deadCount,update_time)"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        DataBaseConnection dbc = new DataBaseConnection();
        dbc.getConnection().setAutoCommit(false);
        PreparedStatement pstmt =dbc.getConnection().prepareStatement(sql);
        in.next();
        while (in.hasNext()) {
            String temp1 = in.nextLine();
            String[] temp = temp1.split(",");

            if (temp.length < 15)
                continue;
            if (temp.length == 15) {
                pstmt.setString(1, temp[0]);
                pstmt.setString(2, temp[1]);
                pstmt.setString(3, temp[2]);
                pstmt.setString(4, temp[3]);
                pstmt.setString(5, temp[4]);
                pstmt.setString(6, temp[5]);
                pstmt.setString(7, temp[6]);
                pstmt.setString(8, temp[7]);
                pstmt.setString(9, temp[8]);
                pstmt.setString(10, temp[9]);
                pstmt.setString(11, temp[10]);
                pstmt.setString(12, temp[11]);
                pstmt.setString(13, temp[12]);
                pstmt.setString(14, temp[13]);
                pstmt.setString(15, temp[14]);
            }
            pstmt.addBatch();
            pstmt.executeBatch();
            dbc.getConnection().commit();
        }

    }
}
