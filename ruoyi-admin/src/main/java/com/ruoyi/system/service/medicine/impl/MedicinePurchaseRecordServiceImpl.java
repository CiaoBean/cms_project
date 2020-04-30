package com.ruoyi.system.service.medicine.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.system.domain.medicine.MedicinePurchaseRecord;
import com.ruoyi.system.domain.medicine.MedicineStore;
import com.ruoyi.system.mapper.medicine.MedicinePurchaseRecordMapper;
import com.ruoyi.system.mapper.medicine.MedicineStoreMapper;
import com.ruoyi.system.service.medicine.IMedicinePurchaseRecordService;
import com.ruoyi.system.service.medicine.IMedicineStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 进货记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-28
 */
@Service
public class MedicinePurchaseRecordServiceImpl implements IMedicinePurchaseRecordService
{
    @Autowired
    private MedicinePurchaseRecordMapper medicinePurchaseRecordMapper;
    @Autowired
    private IMedicineStoreService medicineStoreService;

    /**
     * 查询进货记录
     * 
     * @param id 进货记录ID
     * @return 进货记录
     */
    @Override
    public MedicinePurchaseRecord selectMedicinePurchaseRecordById(Long id)
    {
        return medicinePurchaseRecordMapper.selectMedicinePurchaseRecordById(id);
    }

    /**
     * 查询进货记录列表
     * 
     * @param medicinePurchaseRecord 进货记录
     * @return 进货记录
     */
    @Override
    public List<MedicinePurchaseRecord> selectMedicinePurchaseRecordList(MedicinePurchaseRecord medicinePurchaseRecord)
    {
        return medicinePurchaseRecordMapper.selectMedicinePurchaseRecordList(medicinePurchaseRecord);
    }

    /**
     * 新增进货记录
     * 
     * @param medicinePurchaseRecord 进货记录
     * @return 结果
     */
    @Override
    public int insertMedicinePurchaseRecord(MedicinePurchaseRecord medicinePurchaseRecord)
    {
        return medicinePurchaseRecordMapper.insertMedicinePurchaseRecord(medicinePurchaseRecord);
    }

    /**
     * 修改进货记录
     * 
     * @param medicinePurchaseRecord 进货记录
     * @return 结果
     */
    @Override
    public int updateMedicinePurchaseRecord(MedicinePurchaseRecord medicinePurchaseRecord)
    {
        return medicinePurchaseRecordMapper.updateMedicinePurchaseRecord(medicinePurchaseRecord);
    }

    /**
     * 删除进货记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMedicinePurchaseRecordByIds(String ids)
    {
        return medicinePurchaseRecordMapper.deleteMedicinePurchaseRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除进货记录信息
     * 
     * @param id 进货记录ID
     * @return 结果
     */
    @Override
    public int deleteMedicinePurchaseRecordById(Long id)
    {
        return medicinePurchaseRecordMapper.deleteMedicinePurchaseRecordById(id);
    }

    /**
     * 根据批号更改库存与添加进货记录
     *
     * @param batchNumber
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addRecordAndChangeStore(String batchNumber,Double beginPrice,Integer num) {
        // 查询库存
        MedicineStore query = new MedicineStore();
        query.setBatchNumber(batchNumber);
        List<MedicineStore> medicineStores = medicineStoreService.selectMedicineStoreList(query);
        if(medicineStores == null || medicineStores.size() !=1){
            return false;
        }
        // 增加库存
        MedicineStore medicineStore = medicineStores.get(0);
        medicineStore.setCount(medicineStore.getCount()+num);
        int update = medicineStoreService.updateMedicineStore(medicineStore);
        if(update == 0 ){
            throw  new RuntimeException("系统错误!");
        }
        //添加记录
        MedicinePurchaseRecord medicinePurchaseRecord = new MedicinePurchaseRecord();
        medicinePurchaseRecord.setBatchNumber(medicineStore.getBatchNumber());
        medicinePurchaseRecord.setBeginDate(medicineStore.getBeginDate() );
        medicinePurchaseRecord.setBeginPrice(beginPrice);
        medicinePurchaseRecord.setDrugName(medicineStore.getDrugName());
        medicinePurchaseRecord.setEndDate(medicineStore.getEndDate());
        medicinePurchaseRecord.setManufacturer(medicineStore.getManufacturer());
        medicinePurchaseRecord.setUnit(medicineStore.getUnit());
        medicinePurchaseRecord.setSpecifications(medicineStore.getSpecifications());
        medicinePurchaseRecord.setNumber(num);
        medicinePurchaseRecord.setPurchaseTime(new Date());
        int insert  = this.medicinePurchaseRecordMapper.insertMedicinePurchaseRecord(medicinePurchaseRecord);
        if(insert == 0 ){
            throw  new RuntimeException("系统错误!");
        }
        return true;
    }
}
