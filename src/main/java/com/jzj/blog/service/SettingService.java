package com.jzj.blog.service;

import com.jzj.blog.po.SysSetting;
import org.springframework.stereotype.Service;


public interface SettingService {
    /*
    * 保存配置
    * */
    SysSetting saveSetting(SysSetting setting);

    /*
    * 获取配置数据
    * */
    SysSetting getSetting();
}
