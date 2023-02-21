package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 薪资管理对象 payroll
 * 
 * @author ruoyi
 * @date 2023-02-20
 */
public class Payroll extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 员工名称 */
    @Excel(name = "员工名称")
    private String employeeId;

    /** 基本工资金额 */
    @Excel(name = "基本工资金额")
    private Long salary;

    /** 奖金 */
    @Excel(name = "奖金")
    private Long bonus;

    /** 罚款 */
    @Excel(name = "罚款")
    private Long deduction;

    /** 缴纳社保金额 */
    @Excel(name = "缴纳社保金额")
    private Long insurance;

    /** 个人所得税金额 */
    @Excel(name = "个人所得税金额")
    private Long tax;

    /** 实际支付金额 */
    @Excel(name = "实际支付金额")
    private Long payment;

    /** 发薪日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发薪日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date paymentDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEmployeeId(String employeeId) 
    {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() 
    {
        return employeeId;
    }
    public void setSalary(Long salary) 
    {
        this.salary = salary;
    }

    public Long getSalary() 
    {
        return salary;
    }
    public void setBonus(Long bonus) 
    {
        this.bonus = bonus;
    }

    public Long getBonus() 
    {
        return bonus;
    }
    public void setDeduction(Long deduction) 
    {
        this.deduction = deduction;
    }

    public Long getDeduction() 
    {
        return deduction;
    }
    public void setInsurance(Long insurance) 
    {
        this.insurance = insurance;
    }

    public Long getInsurance() 
    {
        return insurance;
    }
    public void setTax(Long tax) 
    {
        this.tax = tax;
    }

    public Long getTax() 
    {
        return tax;
    }
    public void setPayment(Long payment) 
    {
        this.payment = payment;
    }

    public Long getPayment() 
    {
        return payment;
    }
    public void setPaymentDate(Date paymentDate) 
    {
        this.paymentDate = paymentDate;
    }

    public Date getPaymentDate() 
    {
        return paymentDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("employeeId", getEmployeeId())
            .append("salary", getSalary())
            .append("bonus", getBonus())
            .append("deduction", getDeduction())
            .append("insurance", getInsurance())
            .append("tax", getTax())
            .append("payment", getPayment())
            .append("paymentDate", getPaymentDate())
            .toString();
    }
}
