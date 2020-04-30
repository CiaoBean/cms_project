package com.ruoyi.system.mapper.medicine;

import com.ruoyi.system.domain.medicine.MedicinePurchaseRecord;

import java.util.List;

/**
 * 进货记录Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-28
 */
public interface MedicinePurchaseRecordMapper 
{
    /**
     * 查询进货记录
     * 
     * @param id 进货记录ID
     * @return 进货记录
     */
    public MedicinePurchaseRecord selectMedicinePurchaseRecordById(Long id);

    /**
     * 查询进货记录列表
     * 
     * @param medicinePurchaseRecord 进货记录
     * @return 进货记录集合
     */
    public List<MedicinePurchaseRecord> selectMedicinePurchaseRecordList(MedicinePurchaseRecord medicinePurchaseRecord);

    /**
     * 新增进货记录
     * 
     * @param medicinePurchaseRecord 进货记录
     * @return 结果
     */
    public int insertMedicinePurchaseRecord(MedicinePurchaseRecord medicinePurchaseRecord);

    /**
     * 修改进货记录
     * 
     * @param medicinePurchaseRecord 进货记录
     * @return 结果
     */
    public int updateMedicinePurchaseRecord(MedicinePurchaseRecord medicinePurchaseRecord);

    /**
     * 删除进货记录
     * 
     * @param id 进货记录ID
     * @return 结果
     */
    public int deleteMedicinePurchaseRecordById(Long id);

    /**
     * 批量删除进货记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMedicinePurchaseRecordByIds(String[] ids);
}
