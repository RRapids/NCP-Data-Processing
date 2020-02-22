package com.soft1851.ncp.jsonData;

import com.soft1851.ncp.dao.AreaDao;
import com.soft1851.ncp.entity.Area;
import com.soft1851.ncp.factory.DaoFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tf_yuan
 * @description TODO
 * @date 2020/2/21
 */
public class DXYAreaJson {
    public static void main(String[] args) throws IOException, SQLException {
        List<Area> areaList = DaoFactory.getAreaDaoInstance().selectAllArea();
        //转为JSON类型
        JSONArray array = JSONArray.fromObject(areaList);
        //创建字符输出流
        FileWriter fileWriter = new FileWriter("D:\\data\\area.json");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(String.valueOf(array));
        System.out.println("JSON文件生成成功");
        //关闭
        fileWriter.close();
    }
}
