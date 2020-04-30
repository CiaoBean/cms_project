package com.ruoyi.web.controller.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;

import javax.servlet.http.HttpServletRequest;

/**
 * 个人信息 业务处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/user/profile")
public class SysProfileController extends BaseController
{
    private static final Logger log = LoggerFactory.getLogger(SysProfileController.class);

    private String prefix = "system/user/profile";

    @Autowired
    private ISysUserService userService;
    

    /**
     * 个人信息
     */
    @GetMapping()
    public String profile(HttpServletRequest request ,ModelMap mmap)
    {
        SysUser user = (SysUser) request.getSession().getAttribute("CURRENT_USER");
        mmap.put("user", user);
        return prefix + "/profile";
    }

    @GetMapping("/checkPassword")
    @ResponseBody
    public boolean checkPassword(HttpServletRequest request ,String password)
    {
        SysUser user = (SysUser) request.getSession().getAttribute("CURRENT_USER");
        if (password.matches(user.getPassword()))
        {
            return true;
        }
        return false;
    }

    @GetMapping("/resetPwd")
    public String resetPwd(HttpServletRequest request ,ModelMap mmap)
    {
        SysUser user = (SysUser) request.getSession().getAttribute("CURRENT_USER");
        mmap.put("user", userService.selectUserById(user.getUserId()));
        return prefix + "/resetPwd";
    }

    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwd(HttpServletRequest request ,String oldPassword, String newPassword)
    {
        SysUser user = (SysUser) request.getSession().getAttribute("CURRENT_USER");
        if (StringUtils.isNotEmpty(newPassword) && oldPassword.equals(user.getPassword()))
        {
            user.setPassword(newPassword);
            if (userService.resetUserPwd(user) > 0)
            {
                // 重新登录
                SysUser newUser = userService.selectUserById(user.getUserId());

                return success();
            }
            return error();
        }
        else
        {
            return error("修改密码失败，旧密码错误");
        }
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit")
    public String edit(HttpServletRequest request ,ModelMap mmap)
    {
        SysUser user = (SysUser) request.getSession().getAttribute("CURRENT_USER");
        mmap.put("user", userService.selectUserById(user.getUserId()));
        return prefix + "/edit";
    }

    /**
     * 修改用户
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(HttpServletRequest request ,SysUser user)
    {
        SysUser currentUser = (SysUser) request.getSession().getAttribute("CURRENT_USER");
        currentUser.setUserName(user.getUserName());
        currentUser.setEmail(user.getEmail());
        currentUser.setPhonenumber(user.getPhonenumber());
        currentUser.setSex(user.getSex());
        if (userService.updateUserInfo(currentUser) > 0)
        {
            return success();
        }
        return error();
    }

    /**
     * 保存头像
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PostMapping("/updateAvatar")
    @ResponseBody
    public AjaxResult updateAvatar(HttpServletRequest request ,@RequestParam("avatarfile") MultipartFile file)
    {
        SysUser currentUser = (SysUser) request.getSession().getAttribute("CURRENT_USER");
        try
        {
            if (!file.isEmpty())
            {
                String avatar = FileUploadUtils.upload(Global.getAvatarPath(), file);
                currentUser.setAvatar(avatar);
                if (userService.updateUserInfo(currentUser) > 0)
                {
                    return success();
                }
            }
            return error();
        }
        catch (Exception e)
        {
            log.error("修改头像失败！", e);
            return error(e.getMessage());
        }
    }
}
