package com.ruoyi.system.service.emp.impl;

import java.util.List;

import com.ruoyi.system.domain.emp.EmpInfo;
import com.ruoyi.system.mapper.emp.EmpInfoMapper;
import com.ruoyi.system.service.emp.IEmpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 员工管理Service业务层处理
 * 
 * @author ha
 * @date 2020-05-06
 */
@Service
public class EmpInfoServiceImpl implements IEmpInfoService
{
    @Autowired
    private EmpInfoMapper empInfoMapper;

    /**
     * 查询员工管理
     * 
     * @param empId 员工管理ID
     * @return 员工管理
     */
    @Override
    public EmpInfo selectEmpInfoById(Long empId)
    {
        return empInfoMapper.selectEmpInfoById(empId);
    }

    /**
     * 查询员工管理列表
     * 
     * @param empInfo 员工管理
     * @return 员工管理
     */
    @Override
    public List<EmpInfo> selectEmpInfoList(EmpInfo empInfo)
    {
        return empInfoMapper.selectEmpInfoList(empInfo);
    }

    /**
     * 新增员工管理
     * 
     * @param empInfo 员工管理
     * @return 结果
     */
    @Override
    public int insertEmpInfo(EmpInfo empInfo)
    {
        return empInfoMapper.insertEmpInfo(empInfo);
    }

    /**
     * 修改员工管理
     * 
     * @param empInfo 员工管理
     * @return 结果
     */
    @Override
    public int updateEmpInfo(EmpInfo empInfo)
    {
        return empInfoMapper.updateEmpInfo(empInfo);
    }

    /**
     * 删除员工管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEmpInfoByIds(String ids)
    {
        return empInfoMapper.deleteEmpInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除员工管理信息
     * 
     * @param empId 员工管理ID
     * @return 结果
     */
    @Override
    public int deleteEmpInfoById(Long empId)
    {
        return empInfoMapper.deleteEmpInfoById(empId);
    }
}
