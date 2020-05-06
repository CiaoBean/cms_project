package com.ruoyi.system.mapper.medicine;


import com.ruoyi.system.domain.medicine.MedicineStore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 药品存储Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-28
 */
public interface MedicineStoreMapper 
{
    /**
     * 查询药品存储
     * 
     * @param id 药品存储ID
     * @return 药品存储
     */
    public MedicineStore selectMedicineStoreById(Long id);

    /**
     * 查询药品存储列表
     * 
     * @param medicineStore 药品存储
     * @return 药品存储集合
     */
    public List<MedicineStore> selectMedicineStoreList(MedicineStore medicineStore);


    /**
     * 查询药品存储低库存列表
     * @param drugName
     * @param manufacturer
     * @param batchNumber
     * @param countLessThan
     * @return
     */
    public List<MedicineStore> selectMedicineStoreListLow(@Param("drugName")String drugName,
                                                          @Param("manufacturer")String manufacturer,
                                                          @Param("batchNumber")String batchNumber,
                                                          @Param("countLessThan")Integer countLessThan);


    /**
     * 新增药品存储
     * 
     * @param medicineStore 药品存储
     * @return 结果
     */
    public int insertMedicineStore(MedicineStore medicineStore);

    /**
     * 修改药品存储
     * 
     * @param medicineStore 药品存储
     * @return 结果
     */
    public int updateMedicineStore(MedicineStore medicineStore);

    /**
     * 删除药品存储
     * 
     * @param id 药品存储ID
     * @return 结果
     */
    public int deleteMedicineStoreById(Long id);

    /**
     * 批量删除药品存储
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMedicineStoreByIds(String[] ids);
}
