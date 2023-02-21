package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 业绩管理对象 performance
 * 
 * @author ruoyi
 * @date 2023-02-20
 */
public class Performance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id 自增长 */
    private Long id;

    /** 员工名称 */
    @Excel(name = "员工名称")
    private String employeeId;

    /** 交易日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "交易日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 销售额 */
    @Excel(name = "销售额")
    private Long sales;

    /** 成本 */
    @Excel(name = "成本")
    private Long expenses;

    /** 总收入 */
    @Excel(name = "总收入")
    private Long revenue;

    /** 纯利润 */
    @Excel(name = "纯利润")
    private Long profit;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productId;

    /** 销售地区 */
    @Excel(name = "销售地区")
    private String region;

    /** 销售渠道 */
    @Excel(name = "销售渠道")
    private String channel;

    /** 详细数量 */
    @Excel(name = "详细数量")
    private Long salesQuantity;

    /** 成本的具体说明 */
    @Excel(name = "成本的具体说明")
    private String expensesDetail;

    /** 税费 */
    @Excel(name = "税费")
    private Long taxes;

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
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }
    public void setSales(Long sales) 
    {
        this.sales = sales;
    }

    public Long getSales() 
    {
        return sales;
    }
    public void setExpenses(Long expenses) 
    {
        this.expenses = expenses;
    }

    public Long getExpenses() 
    {
        return expenses;
    }
    public void setRevenue(Long revenue) 
    {
        this.revenue = revenue;
    }

    public Long getRevenue() 
    {
        return revenue;
    }
    public void setProfit(Long profit) 
    {
        this.profit = profit;
    }

    public Long getProfit() 
    {
        return profit;
    }
    public void setProductId(String productId) 
    {
        this.productId = productId;
    }

    public String getProductId() 
    {
        return productId;
    }
    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setChannel(String channel) 
    {
        this.channel = channel;
    }

    public String getChannel() 
    {
        return channel;
    }
    public void setSalesQuantity(Long salesQuantity) 
    {
        this.salesQuantity = salesQuantity;
    }

    public Long getSalesQuantity() 
    {
        return salesQuantity;
    }
    public void setExpensesDetail(String expensesDetail) 
    {
        this.expensesDetail = expensesDetail;
    }

    public String getExpensesDetail() 
    {
        return expensesDetail;
    }
    public void setTaxes(Long taxes) 
    {
        this.taxes = taxes;
    }

    public Long getTaxes() 
    {
        return taxes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("employeeId", getEmployeeId())
            .append("date", getDate())
            .append("sales", getSales())
            .append("expenses", getExpenses())
            .append("revenue", getRevenue())
            .append("profit", getProfit())
            .append("productId", getProductId())
            .append("region", getRegion())
            .append("channel", getChannel())
            .append("salesQuantity", getSalesQuantity())
            .append("expensesDetail", getExpensesDetail())
            .append("taxes", getTaxes())
            .toString();
    }
}
