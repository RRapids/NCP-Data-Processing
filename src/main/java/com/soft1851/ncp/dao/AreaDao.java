package com.soft1851.ncp.dao;

import com.soft1851.ncp.entity.Area;

import java.sql.SQLException;
import java.util.List;

public interface AreaDao {
    //查询所有
    List<Area> selectAllArea() throws SQLException;
}
