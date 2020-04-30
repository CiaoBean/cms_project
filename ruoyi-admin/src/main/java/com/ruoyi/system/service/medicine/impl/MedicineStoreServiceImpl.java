package com.ruoyi.system.service.medicine.impl;

import java.util.List;

import com.ruoyi.system.domain.medicine.MedicineStore;
import com.ruoyi.system.mapper.medicine.MedicineStoreMapper;
import com.ruoyi.system.service.medicine.IMedicineStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 药品存储Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-28
 */
@Service
public class MedicineStoreServiceImpl implements IMedicineStoreService
{
    @Autowired
    private MedicineStoreMapper medicineStoreMapper;

    /**
     * 查询药品存储
     * 
     * @param id 药品存储ID
     * @return 药品存储
     */
    @Override
    public MedicineStore selectMedicineStoreById(Long id)
    {
        return medicineStoreMapper.selectMedicineStoreById(id);
    }

    /**
     * 查询药品存储列表
     * 
     * @param medicineStore 药品存储
     * @return 药品存储
     */
    @Override
    public List<MedicineStore> selectMedicineStoreList(MedicineStore medicineStore)
    {
        return medicineStoreMapper.selectMedicineStoreList(medicineStore);
    }

    /**
     * 新增药品存储
     * 
     * @param medicineStore 药品存储
     * @return 结果
     */
    @Override
    public int insertMedicineStore(MedicineStore medicineStore)
    {
        return medicineStoreMapper.insertMedicineStore(medicineStore);
    }

    /**
     * 修改药品存储
     * 
     * @param medicineStore 药品存储
     * @return 结果
     */
    @Override
    public int updateMedicineStore(MedicineStore medicineStore)
    {
        return medicineStoreMapper.updateMedicineStore(medicineStore);
    }

    /**
     * 删除药品存储对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMedicineStoreByIds(String ids)
    {
        return medicineStoreMapper.deleteMedicineStoreByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除药品存储信息
     * 
     * @param id 药品存储ID
     * @return 结果
     */
    @Override
    public int deleteMedicineStoreById(Long id)
    {
        return medicineStoreMapper.deleteMedicineStoreById(id);
    }
}
