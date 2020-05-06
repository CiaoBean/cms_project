package com.ruoyi.system.service.emp;

import com.ruoyi.system.domain.emp.EmpInfo;

import java.util.List;

/**
 * 员工管理Service接口
 * 
 * @author ha
 * @date 2020-05-06
 */
public interface IEmpInfoService 
{
    /**
     * 查询员工管理
     * 
     * @param empId 员工管理ID
     * @return 员工管理
     */
    public EmpInfo selectEmpInfoById(Long empId);

    /**
     * 查询员工管理列表
     * 
     * @param empInfo 员工管理
     * @return 员工管理集合
     */
    public List<EmpInfo> selectEmpInfoList(EmpInfo empInfo);

    /**
     * 新增员工管理
     * 
     * @param empInfo 员工管理
     * @return 结果
     */
    public int insertEmpInfo(EmpInfo empInfo);

    /**
     * 修改员工管理
     * 
     * @param empInfo 员工管理
     * @return 结果
     */
    public int updateEmpInfo(EmpInfo empInfo);

    /**
     * 批量删除员工管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEmpInfoByIds(String ids);

    /**
     * 删除员工管理信息
     * 
     * @param empId 员工管理ID
     * @return 结果
     */
    public int deleteEmpInfoById(Long empId);

    /**
     * 批量修改员工为删除状态
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int changeDetleStatusEmpInfoByIds(String ids);

}
