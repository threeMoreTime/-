package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Payroll;

/**
 * 薪资管理Service接口
 * 
 * @author ruoyi
 * @date 2023-02-20
 */
public interface IPayrollService 
{
    /**
     * 查询薪资管理
     * 
     * @param id 薪资管理主键
     * @return 薪资管理
     */
    public Payroll selectPayrollById(Long id);

    /**
     * 查询薪资管理列表
     * 
     * @param payroll 薪资管理
     * @return 薪资管理集合
     */
    public List<Payroll> selectPayrollList(Payroll payroll);

    /**
     * 新增薪资管理
     * 
     * @param payroll 薪资管理
     * @return 结果
     */
    public int insertPayroll(Payroll payroll);

    /**
     * 修改薪资管理
     * 
     * @param payroll 薪资管理
     * @return 结果
     */
    public int updatePayroll(Payroll payroll);

    /**
     * 批量删除薪资管理
     * 
     * @param ids 需要删除的薪资管理主键集合
     * @return 结果
     */
    public int deletePayrollByIds(Long[] ids);

    /**
     * 删除薪资管理信息
     * 
     * @param id 薪资管理主键
     * @return 结果
     */
    public int deletePayrollById(Long id);
}
