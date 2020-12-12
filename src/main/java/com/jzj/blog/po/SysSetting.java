package com.jzj.blog.po;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_syssetting")
//网站设置类
public class SysSetting {

    @Id
    @GeneratedValue
    //设置类id
    private Long id;

    //站点名称
    private String SiteTitle;

    //站点logo
    private String logo;

    //联系qq
    private String qq;

    //联系email
    private String email;

    //是否关闭站点
    private boolean isCloseSite;

    //微信二维码
    private String wechatImg;

    //站点描述
    private String SiteDescription;



}
