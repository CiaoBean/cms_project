package com.ruoyi.web.controller.medicine;

import java.util.List;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.medicine.MedicinePurchaseRecord;
import com.ruoyi.system.service.medicine.IMedicinePurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 进货记录Controller
 * 
 * @author ruoyi
 * @date 2020-04-28
 */
@Controller
@RequestMapping("/medicine/record")
public class MedicinePurchaseRecordController extends BaseController
{
    private String prefix = "medicine/record";

    @Autowired
    private IMedicinePurchaseRecordService medicinePurchaseRecordService;

    @GetMapping()
    public String record()
    {
        return prefix + "/record";
    }


    /**
     * 新增进货记录并更改库存
     */
    @GetMapping("/addRecordAndChangeStore")
    @ResponseBody
    public boolean addRecordAndChangeStore(@RequestParam String batchNumber, @RequestParam Double beginPrice,@RequestParam Integer num) {
        return medicinePurchaseRecordService.addRecordAndChangeStore(batchNumber,beginPrice,num);
    }



    /**
     * 查询进货记录列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MedicinePurchaseRecord medicinePurchaseRecord)
    {
        startPage();
        List<MedicinePurchaseRecord> list = medicinePurchaseRecordService.selectMedicinePurchaseRecordList(medicinePurchaseRecord);
        return getDataTable(list);
    }

    /**
     * 导出进货记录列表
     */
    @Log(title = "进货记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MedicinePurchaseRecord medicinePurchaseRecord)
    {
        List<MedicinePurchaseRecord> list = medicinePurchaseRecordService.selectMedicinePurchaseRecordList(medicinePurchaseRecord);
        ExcelUtil<MedicinePurchaseRecord> util = new ExcelUtil<MedicinePurchaseRecord>(MedicinePurchaseRecord.class);
        return util.exportExcel(list, "record");
    }

    /**
     * 新增进货记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存进货记录
     */
    @Log(title = "进货记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MedicinePurchaseRecord medicinePurchaseRecord)
    {
        return toAjax(medicinePurchaseRecordService.insertMedicinePurchaseRecord(medicinePurchaseRecord));
    }

    /**
     * 修改进货记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MedicinePurchaseRecord medicinePurchaseRecord = medicinePurchaseRecordService.selectMedicinePurchaseRecordById(id);
        mmap.put("medicinePurchaseRecord", medicinePurchaseRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存进货记录
     */
    @Log(title = "进货记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MedicinePurchaseRecord medicinePurchaseRecord)
    {
        return toAjax(medicinePurchaseRecordService.updateMedicinePurchaseRecord(medicinePurchaseRecord));
    }

    /**
     * 删除进货记录
     */
    @Log(title = "进货记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(medicinePurchaseRecordService.deleteMedicinePurchaseRecordByIds(ids));
    }
}
