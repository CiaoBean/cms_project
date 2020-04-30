package com.ruoyi.web.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.domain.SysMenu;
import com.ruoyi.system.service.ISysMenuService;

/**
 * 菜单信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/menu")
public class SysMenuController extends BaseController
{
    private String prefix = "system/menu";

    @Autowired
    private ISysMenuService menuService;

    @GetMapping()
    public String menu()
    {
        return prefix + "/menu";
    }

    @PostMapping("/list")
    @ResponseBody
    public List<SysMenu> list(SysMenu menu)
    {
        List<SysMenu> menuList = menuService.selectMenuList(menu);
        return menuList;
    }

}