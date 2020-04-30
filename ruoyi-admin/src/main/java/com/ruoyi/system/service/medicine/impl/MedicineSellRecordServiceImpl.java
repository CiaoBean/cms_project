package com.ruoyi.system.service.medicine.impl;

import java.util.List;

import com.ruoyi.system.domain.medicine.MedicineSellRecord;
import com.ruoyi.system.domain.medicine.MedicineStore;
import com.ruoyi.system.mapper.medicine.MedicineSellRecordMapper;
import com.ruoyi.system.service.medicine.IMedicineSellRecordService;
import com.ruoyi.system.service.medicine.IMedicineStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 销售记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-30
 */
@Service
public class MedicineSellRecordServiceImpl implements IMedicineSellRecordService
{
    @Autowired
    private MedicineSellRecordMapper medicineSellRecordMapper;
    @Autowired
    private IMedicineStoreService medicineStoreService;

    /**
     * 查询销售记录
     * 
     * @param id 销售记录ID
     * @return 销售记录
     */
    @Override
    public MedicineSellRecord selectMedicineSellRecordById(Long id)
    {
        return medicineSellRecordMapper.selectMedicineSellRecordById(id);
    }

    /**
     * 查询销售记录列表
     * 
     * @param medicineSellRecord 销售记录
     * @return 销售记录
     */
    @Override
    public List<MedicineSellRecord> selectMedicineSellRecordList(MedicineSellRecord medicineSellRecord)
    {
        return medicineSellRecordMapper.selectMedicineSellRecordList(medicineSellRecord);
    }

    /**
     * 新增销售记录
     * 
     * @param medicineSellRecord 销售记录
     * @return 结果
     */
    @Override
    public int insertMedicineSellRecord(MedicineSellRecord medicineSellRecord)
    {

        // 查询库存
        MedicineStore query = new MedicineStore();
        query.setBatchNumber(medicineSellRecord.getBatchNumber());
        List<MedicineStore> medicineStores = medicineStoreService.selectMedicineStoreList(query);
        if(medicineStores == null || medicineStores.size() !=1){
            return 0;
        }
        // 增加库存
        MedicineStore medicineStore = medicineStores.get(0);
        medicineStore.setCount(medicineStore.getCount()-medicineSellRecord.getBuyNum());
        int update = medicineStoreService.updateMedicineStore(medicineStore);
        if(update == 0 ){
            throw  new RuntimeException("系统错误!");
        }

        return medicineSellRecordMapper.insertMedicineSellRecord(medicineSellRecord);
    }

    /**
     * 修改销售记录
     * 
     * @param medicineSellRecord 销售记录
     * @return 结果
     */
    @Override
    public int updateMedicineSellRecord(MedicineSellRecord medicineSellRecord)
    {
        return medicineSellRecordMapper.updateMedicineSellRecord(medicineSellRecord);
    }

    /**
     * 删除销售记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMedicineSellRecordByIds(String ids)
    {
        return medicineSellRecordMapper.deleteMedicineSellRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除销售记录信息
     * 
     * @param id 销售记录ID
     * @return 结果
     */
    @Override
    public int deleteMedicineSellRecordById(Long id)
    {
        return medicineSellRecordMapper.deleteMedicineSellRecordById(id);
    }
}
