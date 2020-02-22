package com.soft1851.ncp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author tf_yuan
 * @description 数据库建立
 * @date 2020/2/16
 */

public class NCPDataBase {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/zhihu?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        Statement stat = conn.createStatement();
        //创建数据库
        stat.executeUpdate("CREATE DATABASE IF NOT EXISTS NCP_data_processing DEFAULT CHARSET utf8 COLLATE utf8_general_ci;");
        stat.close();
        conn.close();
        //打开创建的数据库
        url = "jdbc:mysql://localhost:3306/NCP_data_processing?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
        conn = DriverManager.getConnection(url, "root", "root");
        stat = conn.createStatement();
        //创建area表
        stat.executeUpdate("CREATE TABLE IF NOT EXISTS area(province_name varchar(255) comment '地区名'," +
                "province_englishName varchar(255) comment '地区英文名'," +
                "province_ZipCode varchar(255) comment '地区邮编'," +
                "city_name varchar (255) comment '城市名'," +
                "city_englishName varchar (255) comment '城市英文名'," +
                "city_ZipCode int (10) comment '城市邮编'," +
                "province_confirmedCount int (11) comment '地区确诊数'," +
                "province_suspectedCount int (11) comment '地区疑似人数'," +
                "province_cureCount int (11) comment '地区治愈数'," +
                "province_deadCount int (11) comment '地区死亡数'," +
                "city_firmedCount int (11) comment '城市确诊数'," +
                "city_suspectCount int (11) comment '城市疑似数'," +
                "city_cureCount int (11) comment '城市治愈数'," +
                "city_deadCount int (11) comment '城市死亡数'," +
                "update_tiem DATE comment '更新时间')CHARSET=utf8");
        System.out.println("area表创建成功");
        //创建news表
        stat.executeUpdate("CREATE TABLE IF NOT EXISTS news(_id varchar(255) NOT NULL comment '随机id'," +
                "id varchar (255) comment 'id'," +
                "pub_date varchar(255) comment '发布时间'," +
                "title varchar (255) comment '标题'," +
                "summary varchar (9999) comment '摘要'," +
                "info_source varchar (255) comment '信息来源'," +
                "sourceUrl varchar(255) comment '信息链接'," +
                "province_id varchar(255) comment '省份id'," +
                "provinceName varchar(255) comment '省份'," +
                "createTime varchar(255) comment '创建时间'," +
                "modify_time varchar(255) comment '修改时间'," +
                "entry_way varchar(255) comment '入口通道'," +
                "adopt_type varchar (255) comment'采用类型'," +
                "info_type varchar (255) comment '信息类型'," +
                "data_info_state varchar(255) comment '数据信息'," +
                "data_info_time varchar(255) comment '数据信息时间'," +
                "craw_time varchar(1000) comment '爬虫时间'," +
                "body varchar(255) comment '内容')CHARSET=utf8");
        //为id添加索引
//        stat.executeUpdate("CREATE INDEX id_ind ON news(id ASC)");

        System.out.println("news表创建成功");
        //创建overall表
        stat.executeUpdate("CREATE TABLE IF NOT EXISTS overall(_id varchar(255) NOT NULL comment '随机id'," +
                "infectSource varchar (255) comment '字段替换'," +
                "pass_way varchar (255) comment '字段替换'," +
                "daily_pic varchar (255) comment '日报'," +
                "daily_pics varchar (255) comment '#'," +
                "summary varchar (255) comment '摘要'," +
                "count_remark varchar(255) comment '计数备注'," +
                "current_confirmedCount int (11) comment '当前已确认人数'," +
                "confirmed_count int(11) comment '确认人数'," +
                "suspected_count int (11) comment '疑似人数'," +
                "cureed_count int(11) comment '治愈人数'," +
                "dead_count int(11) comment '死亡人数'," +
                "serious_count int(11) comment'重症人数'," +
                "suspected_incr int(11) comment '怀疑增加'," +
                "current_confirmed_incr int(11) comment '当前确诊增加'," +
                "cured_incr int(11) comment '治愈增加'," +
                "dead_incr int(11) comment '死亡增加'," +
                "virus varchar(255) comment '病毒'," +
                "remark1 varchar(255) comment '备注1'," +
                "remark2 varchar(255) comment '备注2'," +
                "remark3 varchar(255) comment '备注3'," +
                "remark4 varchar(255) comment '备注4'," +
                "remark5 varchar(255) comment '备注5'," +
                "note1 varchar(255) comment '注意1'," +
                "note2 varchar(255) comment '注意2'," +
                "note3 varchar(255) comment '注意3'," +
                "general_remark varchar(255) comment '一般性备注'," +
                "abroad_ramark varchar(255) comment '国外备注'," +
                "marquee varchar(255) comment '选框'," +
                "quangguo_trendchart varchar(255) comment '全国趋势图'," +
                "hbFeiHbTrendChart varchar(255) comment '趋势图'," +
                "update_time DATE comment '更新时间')CHARSET=utf8");
        System.out.println("overall表创建成功");
        //创建rumors表
        stat.executeUpdate("CREATE TABLE IF NOT EXISTS rumors(_id varchar(255) comment '随机id'," +
                "body varchar(255) comment '内容'," +
                "id int(11) comment 'id'," +
                "main_summary varchar (255) comment '主要摘要'," +
                "rumor_type varchar (255) comment '谣言类型'," +
                "source_url varchar(255)comment '来源'," +
                "summary varchar(255) comment '摘要'," +
                "title varchar(255) comment '标题'," +
                "craw_time DATE comment '爬虫时间')CHARSET=utf8");
        //为id添加索引
        stat.executeUpdate("CREATE INDEX id_asc ON rumors(id ASC)");
        System.out.println("rumors表创建成功");
        stat.close();
        conn.close();
    }
}
