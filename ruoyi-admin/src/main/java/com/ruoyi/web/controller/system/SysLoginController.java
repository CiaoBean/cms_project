package com.ruoyi.web.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.util.CaptchaCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;

import java.io.IOException;
import java.util.List;

/**
 * 登录验证
 * 
 * @author ruoyi
 */
@Controller
public class SysLoginController extends BaseController
{
    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request))
        {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }

        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(HttpServletRequest request ,String username, String password,String validateCode)
    {

        HttpSession session = request.getSession();
        String loginVerifyCode = (String)session.getAttribute("LOGIN_VERIFY");
        if(StringUtils.isBlank(loginVerifyCode)|| StringUtils.isBlank(validateCode)){
            return error("验证码错误!");
        }
        if(!validateCode.toLowerCase().equals(loginVerifyCode.toLowerCase())){
            return error("验证码错误!");
        }
        // 获取用户
        List<SysUser> users = sysUserService.selectByLoginNameAndPassword(username,password);
        if(users != null && users.size() ==1){
            session.setAttribute("CURRENT_USER",users.get(0));
            return success();
        }else{
            return error("用户不存在/密码错误");
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request)
    {
        if( request.getSession().getAttribute("CURRENT_USER") != null){
            request.getSession().removeAttribute("CURRENT_USER");
        }
        return "login";
    }



    /**
     * 验证码以流的形式响应给客户端
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/drawCode")
    @ResponseBody
    public  void  drawCaptcha( HttpServletResponse response,HttpServletRequest request) throws IOException {
        //生成4位随机验证码
        String code= new CaptchaCodeUtil().randomStr(4);
        //id和验证码存入redis，3分钟有效
        //指定验证码长宽
        CaptchaCodeUtil vCode = new CaptchaCodeUtil(116,36,4,10,code);
        request.getSession().setAttribute("LOGIN_VERIFY",code);
        vCode.write(response.getOutputStream());
    }
}
