package com.ruoyi.system.domain.medicine;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 销售记录对象 medicine_sell_record
 * 
 * @author ruoyi
 * @date 2020-04-30
 */
public class MedicineSellRecord extends BaseEntity
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

    /** 购买价 */
    @Excel(name = "购买价")
    private Double buyPrice;

    /** 购买人 */
    @Excel(name = "购买人")
    private String buyName;

    /** 购买人手机 */
    @Excel(name = "购买人手机")
    private String buyPhone;

    /** 购买时间 */
    @Excel(name = "购买时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date buyTime;

    /** 购买数量 */
    @Excel(name = "购买数量")
    private Integer buyNum;

    /** 生产日期 */
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginDate;

    /** 有效日期 */
    @Excel(name = "有效日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 批号 */
    @Excel(name = "批号")
    private String batchNumber;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 规格 */
    @Excel(name = "规格")
    private String specifications;

    /** 销售备注 */
    @Excel(name = "销售备注")
    private String sellRemark;

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
    public void setBuyPrice(Double buyPrice) 
    {
        this.buyPrice = buyPrice;
    }

    public Double getBuyPrice() 
    {
        return buyPrice;
    }
    public void setBuyName(String buyName) 
    {
        this.buyName = buyName;
    }

    public String getBuyName() 
    {
        return buyName;
    }
    public void setBuyPhone(String buyPhone) 
    {
        this.buyPhone = buyPhone;
    }

    public String getBuyPhone() 
    {
        return buyPhone;
    }
    public void setBuyTime(Date buyTime) 
    {
        this.buyTime = buyTime;
    }

    public Date getBuyTime() 
    {
        return buyTime;
    }
    public void setBuyNum(Integer buyNum) 
    {
        this.buyNum = buyNum;
    }

    public Integer getBuyNum() 
    {
        return buyNum;
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
    public void setSellRemark(String sellRemark) 
    {
        this.sellRemark = sellRemark;
    }

    public String getSellRemark() 
    {
        return sellRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("drugName", getDrugName())
            .append("manufacturer", getManufacturer())
            .append("buyPrice", getBuyPrice())
            .append("buyName", getBuyName())
            .append("buyPhone", getBuyPhone())
            .append("buyTime", getBuyTime())
            .append("buyNum", getBuyNum())
            .append("beginDate", getBeginDate())
            .append("endDate", getEndDate())
            .append("batchNumber", getBatchNumber())
            .append("unit", getUnit())
            .append("specifications", getSpecifications())
            .append("sellRemark", getSellRemark())
            .toString();
    }
}
