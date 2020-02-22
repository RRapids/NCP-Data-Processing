package com.soft1851.ncp.factory;

import com.soft1851.ncp.dao.AreaDao;
import com.soft1851.ncp.dao.NewsDao;
import com.soft1851.ncp.dao.OverallDao;
import com.soft1851.ncp.dao.RumorsDao;
import com.soft1851.ncp.dao.impl.AreaDaoImpl;
import com.soft1851.ncp.dao.impl.NewsDaoImpl;
import com.soft1851.ncp.dao.impl.OverallDaoImpl;
import com.soft1851.ncp.dao.impl.RumorsDaoImpl;

/**
 * @author tf_yuan
 * @description TODO
 * @date 2020/2/21
 */
public class DaoFactory {
    public static AreaDao getAreaDaoInstance() {
        return new AreaDaoImpl();
    }

    public static NewsDao getNewsDaoInstance() {
        return new NewsDaoImpl();
    }
    public static OverallDao getOverallDaoInstance() {
        return new OverallDaoImpl();
    }
    public static RumorsDao getRumorsDaoInstance() {
        return new RumorsDaoImpl();
    }
}
