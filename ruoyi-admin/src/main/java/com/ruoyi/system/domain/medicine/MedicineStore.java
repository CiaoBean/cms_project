package com.ruoyi.system.domain.medicine;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 药品存储对象 medicine_store
 * 
 * @author ruoyi
 * @date 2020-04-28
 */
public class MedicineStore extends BaseEntity
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

    /** 销售价格 */
    @Excel(name = "销售价格")
    private Double price;

    /** 生产日期 */
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginDate;

    /** 有效日期 */
    @Excel(name = "有效日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 批号 */
    @Excel(name = "批号")
    private String batchNumber;

    /** 存放地址 */
    @Excel(name = "存放地址")
    private String location;

    /** 库存 */
    @Excel(name = "库存")
    private Integer count;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 规格 */
    @Excel(name = "规格")
    private String specifications;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setBeginDate(Date beginDate) {
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
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setCount(Integer count) 
    {
        this.count = count;
    }

    public Integer getCount() 
    {
        return count;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("drugName", getDrugName())
            .append("manufacturer", getManufacturer())
            .append("price", getPrice())
            .append("beginDate", getBeginDate())
            .append("endDate", getEndDate())
            .append("batchNumber", getBatchNumber())
            .append("location", getLocation())
            .append("count", getCount())
            .append("unit", getUnit())
            .append("specifications", getSpecifications())
            .append("remark", getRemark())
            .toString();
    }
}
