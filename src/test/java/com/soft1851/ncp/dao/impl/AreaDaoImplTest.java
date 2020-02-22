package com.soft1851.ncp.dao.impl;


import com.soft1851.ncp.dao.AreaDao;

import com.soft1851.ncp.entity.Area;
import com.soft1851.ncp.factory.DaoFactory;

import java.sql.SQLException;
import java.util.List;

public class AreaDaoImplTest {
    private AreaDao areaDao = DaoFactory.getAreaDaoInstance();

    @org.junit.Test
    public void selectAllArea() {
        List<Area> areas = null;
        try {
            areas = areaDao.selectAllArea();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        areas.forEach(area -> System.out.println(area));
    }
}