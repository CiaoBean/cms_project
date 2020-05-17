package com.ruoyi.web.controller.system;

import java.util.ArrayList;
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
        List<SysMenu> filterMenus = new ArrayList<>();
        // 根据用户角色过滤
        if("管理员".equals(user.getUserType())){
//            for(SysMenu sysMenu : menus){
//                if("系统管理".equals(sysMenu.getMenuName())||"员工管理".equals(sysMenu.getMenuName())){
//                    filterMenus.add(sysMenu);
//                }
//            }
            filterMenus.addAll(menus);
        }else {
            for(SysMenu sysMenu : menus){
                if("药品管理".equals(sysMenu.getMenuName())||"员工管理".equals(sysMenu.getMenuName())|| "系统管理".equals(sysMenu.getMenuName())){
                    filterMenus.add(sysMenu);
                }
            }
            // 移除用户列表
            List<SysMenu> childrenUserMenu = new ArrayList<>();
            for(SysMenu sysMenu : filterMenus){
                if("系统管理".equals(sysMenu.getMenuName())){
                    for(SysMenu childSysMenu :sysMenu.getChildren()){
                        if(!"用户列表".equals(childSysMenu.getMenuName())){
                            childrenUserMenu.add(childSysMenu);
                        }
                    }
                    sysMenu.setChildren(childrenUserMenu);
                }
            }
        }

        mmap.put("menus", filterMenus);
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
