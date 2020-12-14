package com.jzj.blog.web.admin;

import com.jzj.blog.po.SysSetting;
import com.jzj.blog.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class SettingConterller {
    @Autowired
    private SettingService settingService;

    @GetMapping("/setting")
    public String Index(Model model){
        SysSetting setting = settingService.getSetting();
        model.addAttribute("setting",setting);
        return "admin/setting-input";
    }
    @PostMapping("/input")
    public String input(@Valid SysSetting sysSetting, RedirectAttributes attributes){
        SysSetting setting = settingService.saveSetting(sysSetting);//调用保存操作
        if(setting==null){
            attributes.addFlashAttribute("message","新增失败");
        }else{
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/setting";
    }
}
