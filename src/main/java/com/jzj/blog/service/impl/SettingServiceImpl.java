package com.jzj.blog.service.impl;

import com.jzj.blog.NotFoundException;
import com.jzj.blog.dao.SettingRepository;
import com.jzj.blog.po.SysSetting;
import com.jzj.blog.service.SettingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    private SettingRepository settingRepository;
    @Override
    public SysSetting saveSetting(SysSetting setting) {
        SysSetting s = settingRepository.findAll().get(0);
        if(s==null){
            setting.setCreateTime(new Date());
            return settingRepository.save(setting); //当未查找到后创建第一条配置信息
        }
        setting.setUpdateTime(new Date());
        setting.setId(s.getId());
        BeanUtils.copyProperties(setting,s); //把传进来的model复制给查询出来的s
        return settingRepository.save(s);
    }

    @Override
    public SysSetting getSetting() {
        return settingRepository.findAll().get(0);
    }
}
