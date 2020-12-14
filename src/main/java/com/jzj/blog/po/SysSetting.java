package com.jzj.blog.po;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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
    private String siteTitle;

    //站点logo
    private String logo;

    //联系qq
    private String qq;

    //联系email
    private String email;

    //是否关闭站点
    private boolean iscloseSite;

    //微信二维码
    private String wechatImg;

    //站点描述
    private String siteDescription;

    //创建时间
    private Date createTime;

    //最后的修改时间
    private Date updateTime;

}
