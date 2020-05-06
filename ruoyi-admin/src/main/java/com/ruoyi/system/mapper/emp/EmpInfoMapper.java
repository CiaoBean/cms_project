package com.ruoyi.system.mapper.emp;

import com.ruoyi.system.domain.emp.EmpInfo;

import java.util.List;

/**
 * 员工管理Mapper接口
 * 
 * @author ha
 * @date 2020-05-06
 */
public interface EmpInfoMapper 
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
     * 删除员工管理
     * 
     * @param empId 员工管理ID
     * @return 结果
     */
    public int deleteEmpInfoById(Long empId);

    /**
     * 批量删除员工管理
     * 
     * @param empIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteEmpInfoByIds(String[] empIds);
}
