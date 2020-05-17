package com.ruoyi.web.controller.emp;

import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.emp.EmpInfo;
import com.ruoyi.system.service.emp.IEmpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 员工管理Controller
 * 
 * @author ha
 * @date 2020-05-06
 */
@Controller
@RequestMapping("/emp/info")
public class EmpInfoController extends BaseController
{
    private String prefix = "emp/info";

    @Autowired
    private IEmpInfoService empInfoService;

    @GetMapping()
    public String info(HttpServletRequest request)
    {
        // 取身份信息
        SysUser user = (SysUser) request.getSession().getAttribute("CURRENT_USER");
        if("管理员".equals(user.getUserType())){
            return prefix + "/info";
        }else{
            return prefix + "/infoForNormal";
        }
    }

    /**
     * 查询员工管理列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EmpInfo empInfo)
    {
        startPage();
        List<EmpInfo> list = empInfoService.selectEmpInfoList(empInfo);
        return getDataTable(list);
    }

    /**
     * 新增员工管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存员工管理
     */
    @Log(title = "员工管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EmpInfo empInfo)
    {
        return toAjax(empInfoService.insertEmpInfo(empInfo));
    }

    /**
     * 修改员工管理
     */
    @GetMapping("/edit/{empId}")
    public String edit(@PathVariable("empId") Long empId, ModelMap mmap)
    {
        EmpInfo empInfo = empInfoService.selectEmpInfoById(empId);
        mmap.put("empInfo", empInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工管理
     */
    @Log(title = "员工管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EmpInfo empInfo)
    {
        return toAjax(empInfoService.updateEmpInfo(empInfo));
    }

    /**
     * 删除员工管理
     */
    @Log(title = "员工管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(empInfoService.changeDetleStatusEmpInfoByIds(ids));
    }
}
