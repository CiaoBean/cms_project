package com.ruoyi.system.service.medicine;

import com.ruoyi.system.domain.medicine.MedicineSellRecord;

import java.util.List;

/**
 * 销售记录Service接口
 * 
 * @author ruoyi
 * @date 2020-04-30
 */
public interface IMedicineSellRecordService 
{
    /**
     * 查询销售记录
     * 
     * @param id 销售记录ID
     * @return 销售记录
     */
    public MedicineSellRecord selectMedicineSellRecordById(Long id);

    /**
     * 查询销售记录列表
     * 
     * @param medicineSellRecord 销售记录
     * @return 销售记录集合
     */
    public List<MedicineSellRecord> selectMedicineSellRecordList(MedicineSellRecord medicineSellRecord);

    /**
     * 新增销售记录
     * 
     * @param medicineSellRecord 销售记录
     * @return 结果
     */
    public int insertMedicineSellRecord(MedicineSellRecord medicineSellRecord);

    /**
     * 修改销售记录
     * 
     * @param medicineSellRecord 销售记录
     * @return 结果
     */
    public int updateMedicineSellRecord(MedicineSellRecord medicineSellRecord);

    /**
     * 批量删除销售记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMedicineSellRecordByIds(String ids);

    /**
     * 删除销售记录信息
     * 
     * @param id 销售记录ID
     * @return 结果
     */
    public int deleteMedicineSellRecordById(Long id);
}
