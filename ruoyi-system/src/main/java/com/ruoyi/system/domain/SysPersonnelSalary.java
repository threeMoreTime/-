package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 薪资管理对象 sys_personnel_salary
 *
 * @author ruoyi
 * @date 2022-11-13
 */
public class SysPersonnelSalary extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工id主键自增 */
    private Long personId;

    /** 员工 */
    @Excel(name = "员工")
    private String personnel;

    /** 岗位 */
    @Excel(name = "岗位")
    private String position;

    /** 薪资 */
    @Excel(name = "薪资")
    private Long salary;

    public void setPersonId(Long personId)
    {
        this.personId = personId;
    }

    public Long getPersonId()
    {
        return personId;
    }
    public void setPersonnel(String personnel)
    {
        this.personnel = personnel;
    }

    public String getPersonnel()
    {
        return personnel;
    }
    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getPosition()
    {
        return position;
    }
    public void setSalary(Long salary)
    {
        this.salary = salary;
    }

    public Long getSalary()
    {
        return salary;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("personId", getPersonId())
            .append("personnel", getPersonnel())
            .append("position", getPosition())
            .append("salary", getSalary())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
