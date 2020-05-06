package com.ruoyi.system.domain.emp;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工管理对象 emp_info
 * 
 * @author ha
 * @date 2020-05-06
 */
public class EmpInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工号 */
    private Long empId;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String empName;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String identityCard;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 薪水 */
    @Excel(name = "薪水")
    private Double salary;

    /** 是否在职 (0:在职,1:已离职 ) */
    @Excel(name = "是否在职 (0:在职,1:已离职 )")
    private Integer jobStatus;

    /** 入职时间 */
    @Excel(name = "入职时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entryTime;

    /** 离职时间 */
    @Excel(name = "离职时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date leaveTime;

    /** 0:有效, 1无效 */
    @Excel(name = "0:有效, 1无效")
    private Integer dataStatus;


    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("empId", getEmpId())
            .append("empName", getEmpName())
            .append("gender", getGender())
            .append("identityCard", getIdentityCard())
            .append("phone", getPhone())
            .append("salary", getSalary())
            .append("jobStatus", getJobStatus())
            .append("entryTime", getEntryTime())
            .append("leaveTime", getLeaveTime())
            .append("dataStatus", getDataStatus())
            .toString();
    }
}
