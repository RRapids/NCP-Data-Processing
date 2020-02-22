package com.soft1851.ncp.dao.impl;

import com.soft1851.ncp.dao.AreaDao;
import com.soft1851.ncp.entity.Area;
import com.soft1851.ncp.until.DataBaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tf_yuan
 * @description TODO
 * @date 2020/2/21
 */

public class AreaDaoImpl implements AreaDao {
    @Override
    public List<Area> selectAllArea() throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        String sql = "SELECT * FROM area";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();
        List<Area> areaList = new ArrayList<>();
        while (resultSet.next()) {
            Area area = new Area();
            area.setProvinceName(resultSet.getString("province_name"));
            area.setProvinceEnglishName(resultSet.getString("province_englishName"));
            area.setProvinceZipCode(resultSet.getInt("province_ZipCode"));
            area.setCityName(resultSet.getString("city_name"));
            area.setCityEnglishName(resultSet.getString("city_englishName"));
            area.setCityZipCode(resultSet.getInt("city_ZipCode"));
            area.setProvinceConfirmedCount(resultSet.getInt("province_confirmedCount"));
            area.setCitySuspectedCount(resultSet.getInt("province_suspectedCount"));
            area.setProvinceCureCount(resultSet.getInt("province_cureCount"));
            area.setProvinceDeadCount(resultSet.getInt("province_deadCount"));
            area.setCityConfirmedCount(resultSet.getInt("city_firmedCount"));
            area.setCitySuspectedCount(resultSet.getInt("city_suspectCount"));
            area.setCityCureCount(resultSet.getInt("city_cureCount"));
            area.setCityDeadCount(resultSet.getInt("city_deadCount"));
            areaList.add(area);
        }
        resultSet.close();
        pstmt.close();
        dbc.close();
        return areaList;
    }
}
