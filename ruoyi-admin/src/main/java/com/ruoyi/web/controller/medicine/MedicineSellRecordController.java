package com.ruoyi.web.controller.medicine;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.medicine.MedicineSellRecord;
import com.ruoyi.system.domain.medicine.MedicineStore;
import com.ruoyi.system.service.medicine.IMedicineSellRecordService;
import com.ruoyi.system.service.medicine.IMedicineStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 销售记录Controller
 * 
 * @author ruoyi
 * @date 2020-04-30
 */
@Controller
@RequestMapping("/medicine/sell")
public class MedicineSellRecordController extends BaseController
{
    private String prefix = "medicine/sell";

    @Autowired
    private IMedicineSellRecordService medicineSellRecordService;
    @Autowired
    private IMedicineStoreService medicineStoreService;

    @GetMapping()
    public String sell()
    {
        return prefix + "/sell";
    }

    /**
     * 查询销售记录列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MedicineSellRecord medicineSellRecord)
    {
        startPage();
        List<MedicineSellRecord> list = medicineSellRecordService.selectMedicineSellRecordList(medicineSellRecord);
        return getDataTable(list);
    }

    /**
     * 导出销售记录列表
     */
    @Log(title = "销售记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MedicineSellRecord medicineSellRecord)
    {
        List<MedicineSellRecord> list = medicineSellRecordService.selectMedicineSellRecordList(medicineSellRecord);
        ExcelUtil<MedicineSellRecord> util = new ExcelUtil<MedicineSellRecord>(MedicineSellRecord.class);
        return util.exportExcel(list, "sell");
    }

    /**
     * 新增销售记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存销售记录
     */
    @Log(title = "销售记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MedicineSellRecord medicineSellRecord)
    {
        // 如果不存在批号直接返回错误
        if(StringUtils.isBlank(medicineSellRecord.getBatchNumber())){
            return AjaxResult.error("批次号不能为空!");
        }
        return toAjax(medicineSellRecordService.insertMedicineSellRecord(medicineSellRecord));
    }

    /**
     * 修改销售记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MedicineSellRecord medicineSellRecord = medicineSellRecordService.selectMedicineSellRecordById(id);
        mmap.put("medicineSellRecord", medicineSellRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存销售记录
     */
    @Log(title = "销售记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MedicineSellRecord medicineSellRecord)
    {
        return toAjax(medicineSellRecordService.updateMedicineSellRecord(medicineSellRecord));
    }

    /**
     * 删除销售记录
     */
    @Log(title = "销售记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(medicineSellRecordService.deleteMedicineSellRecordByIds(ids));
    }


    /**
     * 自定义新增销售记录
     */
    @GetMapping("/addCus")
    public String addCus(@RequestParam String batchNumber, ModelMap mmap)
    {
        // 查询库存
        MedicineStore query = new MedicineStore();
        query.setBatchNumber(batchNumber);
        List<MedicineStore> medicineStores = medicineStoreService.selectMedicineStoreList(query);
        if(medicineStores == null || medicineStores.size() !=1){
            return  "error/500";
        }
        // 获取库存对象
        MedicineStore medicineStore = medicineStores.get(0);
        MedicineSellRecord medicineSellRecord = new MedicineSellRecord();
        medicineSellRecord.setDrugName(medicineStore.getDrugName());
        medicineSellRecord.setBatchNumber(medicineStore.getBatchNumber());
        medicineSellRecord.setBeginDate(medicineStore.getBeginDate());
        medicineSellRecord.setEndDate(medicineStore.getEndDate());
        medicineSellRecord.setManufacturer(medicineStore.getManufacturer());
        medicineSellRecord.setSpecifications(medicineStore.getSpecifications());
        medicineSellRecord.setUnit(medicineStore.getUnit());

        mmap.put("medicineSellRecord", medicineSellRecord);
        return prefix + "/sellCus";
    }

}
