package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 业绩管理对象 sys_personalperformance
 *
 * @author ruoyi
 * @date 2022-11-15
 */
public class SysPersonalperformance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工编号 */
    private Long personalId;

    /** 员工 */
    @Excel(name = "员工")
    private String personnel;

    /** 岗位 */
    @Excel(name = "岗位")
    private String position;

    /** 业绩 */
    @Excel(name = "业绩")
    private Long performance;

    public void setPersonalId(Long personalId)
    {
        this.personalId = personalId;
    }

    public Long getPersonalId()
    {
        return personalId;
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
    public void setPerformance(Long performance)
    {
        this.performance = performance;
    }

    public Long getPerformance()
    {
        return performance;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("personalId", getPersonalId())
                .append("personnel", getPersonnel())
                .append("position", getPosition())
                .append("performance", getPerformance())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
