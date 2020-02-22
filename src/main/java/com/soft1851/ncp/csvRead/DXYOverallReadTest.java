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
 * @date 2020/2/21
 */
public class DXYOverallReadTest {
    public static void main(String[] args) throws FileNotFoundException, SQLException {
        long startTime = System.currentTimeMillis();
        File file = new File("D:\\javastudy\\project\\NCP-Data-Processing\\src\\main\\resources\\data\\DXYOverall.csv");
        System.out.println("开始导入数据");
        Scanner in = new Scanner(file);
        insert_data(in);
        long EndTime = System.currentTimeMillis();
        long time = (EndTime - startTime) / 1000;
        System.out.println("导入数据（DXYOverall.csv）共用时：" + time);
    }

    private static void insert_data(Scanner in) throws SQLException {

        String sql = "insert into overall (_id,infectSource,pass_way,daily_pic,daily_pics," +
                "summary,count_remark,current_confirmedCount,confirmed_count," +
                "suspected_count,cureed_count,dead_count,serious_count,suspected_incr,current_confirmed_incr," +
                "cured_incr,dead_incr,virus,remark1,remark2,remark3,remark4,remark5," +
                "note1,note2,note3,general_remark,abroad_ramark,marquee,quangguo_trendchart,hbFeiHbTrendChart,update_time)"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        DataBaseConnection dbc = new DataBaseConnection();
        dbc.getConnection().setAutoCommit(false);
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        in.next();
        while (in.hasNext()) {
            String temp1 = in.nextLine();
            temp1.replace("'", "''");
            String[] temp = temp1.split(",");
            if (temp.length < 32)
                continue;

            if (temp.length == 32) {
                pstmt.setObject(1, temp[0]);
                pstmt.setObject(2, temp[1]);
                pstmt.setObject(3, temp[2]);
                pstmt.setObject(4, temp[3]);
                pstmt.setObject(5, temp[4]);
                pstmt.setObject(6, temp[5]);
                pstmt.setObject(7, temp[6]);
                pstmt.setObject(8, temp[7]);
                pstmt.setObject(9, temp[8]);
                pstmt.setObject(10, temp[9]);
                pstmt.setObject(11, temp[10]);
                pstmt.setObject(12, temp[11]);
                pstmt.setObject(13, temp[12]);
                pstmt.setObject(14, temp[13]);
                pstmt.setObject(15, temp[14]);
                pstmt.setObject(16, temp[15]);
                pstmt.setObject(17, temp[16]);
                pstmt.setObject(18, temp[17]);
                pstmt.setObject(19, temp[18]);
                pstmt.setObject(20, temp[19]);
                pstmt.setObject(21, temp[20]);
                pstmt.setObject(22, temp[21]);
                pstmt.setObject(23, temp[22]);
                pstmt.setObject(24, temp[23]);
                pstmt.setObject(25, temp[24]);
                pstmt.setObject(26, temp[25]);
                pstmt.setObject(27, temp[26]);
                pstmt.setObject(28, temp[27]);
                pstmt.setObject(29, temp[28]);
                pstmt.setObject(30, temp[29]);
                pstmt.setObject(31, temp[30]);
                pstmt.setObject(32, temp[31]);
            }
            pstmt.addBatch();
            pstmt.executeBatch();
            dbc.getConnection().commit();
        }
    }
}
