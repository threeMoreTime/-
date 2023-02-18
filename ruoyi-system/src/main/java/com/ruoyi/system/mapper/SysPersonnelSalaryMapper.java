package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysPersonnelSalary;

/**
 * 薪资管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-13
 */
public interface SysPersonnelSalaryMapper 
{
    /**
     * 查询薪资管理
     * 
     * @param personId 薪资管理主键
     * @return 薪资管理
     */
    public SysPersonnelSalary selectSysPersonnelSalaryByPersonId(Long personId);

    /**
     * 查询薪资管理列表
     * 
     * @param sysPersonnelSalary 薪资管理
     * @return 薪资管理集合
     */
    public List<SysPersonnelSalary> selectSysPersonnelSalaryList(SysPersonnelSalary sysPersonnelSalary);

    /**
     * 新增薪资管理
     * 
     * @param sysPersonnelSalary 薪资管理
     * @return 结果
     */
    public int insertSysPersonnelSalary(SysPersonnelSalary sysPersonnelSalary);

    /**
     * 修改薪资管理
     * 
     * @param sysPersonnelSalary 薪资管理
     * @return 结果
     */
    public int updateSysPersonnelSalary(SysPersonnelSalary sysPersonnelSalary);

    /**
     * 删除薪资管理
     * 
     * @param personId 薪资管理主键
     * @return 结果
     */
    public int deleteSysPersonnelSalaryByPersonId(Long personId);

    /**
     * 批量删除薪资管理
     * 
     * @param personIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysPersonnelSalaryByPersonIds(Long[] personIds);
}
