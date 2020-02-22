package com.soft1851.ncp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
/**
 * @author tf_yuan
 * @description 地区
 * @date 2020/2/17
 */
@Data
@AllArgsConstructor
public class Area {
    private String provinceName;//地区名
    private String provinceEnglishName;//地区英文名
    private Integer provinceZipCode;//地区邮编
    private String cityName;//城市名
    private String cityEnglishName;//城市英文名
    private Integer cityZipCode;//城市邮编
    private Integer provinceConfirmedCount;//地区确诊数
    private Integer provinceSuspectedCount;//地区疑似人数
    private Integer provinceCureCount;//地区治愈数
    private Integer provinceDeadCount;//地区死亡数
    private Integer cityConfirmedCount;//城市确诊数
    private Integer citySuspectedCount;//城市疑似数
    private Integer cityCureCount;//城市治愈数
    private Integer cityDeadCount;//城市死亡数
    private Date updateTime;//更新时间

    public Area() {

    }
}
