package com.ruoyi.system.domain.medicine;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 进货记录对象 medicine_purchase_record
 * 
 * @author ruoyi
 * @date 2020-04-28
 */
public class MedicinePurchaseRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String drugName;

    /** 厂商 */
    @Excel(name = "厂商")
    private String manufacturer;

    /** 进价 */
    @Excel(name = "进价")
    private Double beginPrice;

    /** 生产日期 */
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginDate;

    /** 有效日期 */
    @Excel(name = "有效日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 批号 */
    @Excel(name = "批号")
    private String batchNumber;

    /** 进货量 */
    @Excel(name = "进货量")
    private Integer number;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 规格 */
    @Excel(name = "规格")
    private String specifications;

    /** 进货时间 */
    @Excel(name = "进货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchaseTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDrugName(String drugName) 
    {
        this.drugName = drugName;
    }

    public String getDrugName() 
    {
        return drugName;
    }
    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }
    public void setBeginPrice(Double beginPrice) 
    {
        this.beginPrice = beginPrice;
    }

    public Double getBeginPrice() 
    {
        return beginPrice;
    }
    public void setBeginDate(Date beginDate) 
    {
        this.beginDate = beginDate;
    }

    public Date getBeginDate() 
    {
        return beginDate;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }
    public void setBatchNumber(String batchNumber) 
    {
        this.batchNumber = batchNumber;
    }

    public String getBatchNumber() 
    {
        return batchNumber;
    }
    public void setNumber(Integer number) 
    {
        this.number = number;
    }

    public Integer getNumber() 
    {
        return number;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setSpecifications(String specifications) 
    {
        this.specifications = specifications;
    }

    public String getSpecifications() 
    {
        return specifications;
    }
    public void setPurchaseTime(Date purchaseTime) 
    {
        this.purchaseTime = purchaseTime;
    }

    public Date getPurchaseTime() 
    {
        return purchaseTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("drugName", getDrugName())
            .append("manufacturer", getManufacturer())
            .append("beginPrice", getBeginPrice())
            .append("beginDate", getBeginDate())
            .append("endDate", getEndDate())
            .append("batchNumber", getBatchNumber())
            .append("number", getNumber())
            .append("unit", getUnit())
            .append("specifications", getSpecifications())
            .append("purchaseTime", getPurchaseTime())
            .toString();
    }
}
