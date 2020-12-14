package com.jzj.blog.dao;


import com.jzj.blog.po.SysSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<SysSetting,Long> {

}
