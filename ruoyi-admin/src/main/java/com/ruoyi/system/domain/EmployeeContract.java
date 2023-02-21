package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 奖惩管理对象 employee_contract
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
public class EmployeeContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phoneNumber;

    /** 合同签订时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同签订时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 合同结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 合同期限 */
    @Excel(name = "合同期限")
    private Long contractTerm;

    /** 奖惩信息 */
    @Excel(name = "奖惩信息")
    private String rewardsAndPunishments;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }
    public void setContractTerm(Long contractTerm) 
    {
        this.contractTerm = contractTerm;
    }

    public Long getContractTerm() 
    {
        return contractTerm;
    }
    public void setRewardsAndPunishments(String rewardsAndPunishments) 
    {
        this.rewardsAndPunishments = rewardsAndPunishments;
    }

    public String getRewardsAndPunishments() 
    {
        return rewardsAndPunishments;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("email", getEmail())
            .append("phoneNumber", getPhoneNumber())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("contractTerm", getContractTerm())
            .append("rewardsAndPunishments", getRewardsAndPunishments())
            .toString();
    }
}
