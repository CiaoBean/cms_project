package com.ruoyi.web.controller.medicine;

import java.util.List;

import com.ruoyi.system.domain.medicine.MedicineStore;
import com.ruoyi.system.service.medicine.IMedicineStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药品存储Controller
 * 
 * @author ruoyi
 * @date 2020-04-28
 */
@Controller
@RequestMapping("/medicine/store")
public class MedicineStoreController extends BaseController
{
    private String prefix = "medicine/store";

    @Autowired
    private IMedicineStoreService medicineStoreService;

    @GetMapping()
    public String store()
    {
        return prefix + "/store";
    }


    @GetMapping("lowWarning")
    public String lowWarning()
    {
        return prefix + "/storeLow";
    }


    /**
     * 查询药品存储列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MedicineStore medicineStore)
    {
        startPage();
        List<MedicineStore> list = medicineStoreService.selectMedicineStoreList(medicineStore);
        return getDataTable(list);
    }


    /**
     * 查询药品预警存储列表
     */
    @PostMapping("/listLow")
    @ResponseBody
    public TableDataInfo listLow(MedicineStore medicineStore)
    {
        startPage();
        List<MedicineStore> list = medicineStoreService.selectMedicineStoreListLow(medicineStore.getDrugName(),medicineStore.getManufacturer()
                                    ,medicineStore.getBatchNumber(),10);
        return getDataTable(list);
    }

    /**
     * 导出药品存储列表
     */
    @Log(title = "药品存储", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MedicineStore medicineStore)
    {
        List<MedicineStore> list = medicineStoreService.selectMedicineStoreList(medicineStore);
        ExcelUtil<MedicineStore> util = new ExcelUtil<MedicineStore>(MedicineStore.class);
        return util.exportExcel(list, "store");
    }

    /**
     * 新增药品存储
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存药品存储
     */
    @Log(title = "药品存储", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MedicineStore medicineStore)
    {
        // 判断是否批号重复
        MedicineStore query = new MedicineStore();
        query.setBatchNumber(medicineStore.getBatchNumber());
        List<MedicineStore> medicineStores = medicineStoreService.selectMedicineStoreList(query);
        if(medicineStores!= null && medicineStores.size() >= 1){
            return AjaxResult.error("已有重复批号在库存,不能重复添加!");
        }
        return toAjax(medicineStoreService.insertMedicineStore(medicineStore));
    }

    /**
     * 修改药品存储
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MedicineStore medicineStore = medicineStoreService.selectMedicineStoreById(id);
        mmap.put("medicineStore", medicineStore);
        return prefix + "/edit";
    }

    /**
     * 修改保存药品存储
     */
    @Log(title = "药品存储", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MedicineStore medicineStore)
    {
        // 判断是否批号重复
        MedicineStore query = new MedicineStore();
        query.setBatchNumber(medicineStore.getBatchNumber());
        List<MedicineStore> medicineStores = medicineStoreService.selectMedicineStoreList(query);
        if(medicineStores!= null && medicineStores.size() >= 1){
            MedicineStore ms = medicineStores.get(0);
            if(ms.getBatchNumber() != null && ms.getBatchNumber().equals(medicineStore.getBatchNumber())
                    && ms.getId().intValue() != medicineStore.getId().intValue()){
                return AjaxResult.error("已有重复批号在库存,不能重复添加!");
            }
        }

        return toAjax(medicineStoreService.updateMedicineStore(medicineStore));
    }

    /**
     * 删除药品存储
     */
    @Log(title = "药品存储", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(medicineStoreService.deleteMedicineStoreByIds(ids));
    }
}
