package com.soft1851.ncp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author tf_yuan
 * @description 新闻
 * @date 2020/2/17
 */
@Data
@Builder
@AllArgsConstructor
public class News {
    private String _id;//随机id
    private Integer id;
    private Date pubDate;//发布时间
    private String title;//标题
    private String summary;//摘要
    private String infoSource;//信息来源
    private String sourceUrl;//信息链接
    private Integer provinceId;//省份id
    private String provinceName;//省份
    private Date createTime;//创建时间
    private Date modifyTime;//修改时间
    private String entryWay;//入口通道
    private String adoptType;//采用类型
    private String infoType;//信息类型
    private String dataInfoState;//数据信息状态
    private Date dataInfoTime;//数据信息时间
    private Date crawTime;//爬虫时间
    private String body;//内容
}
