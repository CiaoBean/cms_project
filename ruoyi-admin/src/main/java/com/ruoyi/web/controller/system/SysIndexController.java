package com.ruoyi.web.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.system.domain.SysMenu;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysMenuService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 首页 业务处理
 * 
 * @author ruoyi
 */
@Controller
public class SysIndexController extends BaseController
{
    @Autowired
    private ISysMenuService menuService;


    // 系统首页
    @GetMapping("/index")
    public String index(HttpServletRequest request, ModelMap mmap)
    {
        // 取身份信息
        SysUser user = (SysUser) request.getSession().getAttribute("CURRENT_USER");
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusFirst();
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("sideTheme", "theme-dark");
        mmap.put("skinName", "skin-blue");
        mmap.put("copyrightYear","2020");
        mmap.put("demoEnabled",true);
        return "index";
    }

    // 系统首页
    @GetMapping("system/main")
    public String main(HttpServletRequest request, HttpServletResponse response,ModelMap mmap) throws  Exception{
        SysUser user = (SysUser) request.getSession().getAttribute("CURRENT_USER");
        mmap.put("user", user);
        return  "system/user/profile/profileView";
    }

}
