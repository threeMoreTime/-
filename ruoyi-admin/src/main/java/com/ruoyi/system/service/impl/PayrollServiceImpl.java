package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PayrollMapper;
import com.ruoyi.system.domain.Payroll;
import com.ruoyi.system.service.IPayrollService;

/**
 * 薪资管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-20
 */
@Service
public class PayrollServiceImpl implements IPayrollService 
{
    @Autowired
    private PayrollMapper payrollMapper;

    /**
     * 查询薪资管理
     * 
     * @param id 薪资管理主键
     * @return 薪资管理
     */
    @Override
    public Payroll selectPayrollById(Long id)
    {
        return payrollMapper.selectPayrollById(id);
    }

    /**
     * 查询薪资管理列表
     * 
     * @param payroll 薪资管理
     * @return 薪资管理
     */
    @Override
    public List<Payroll> selectPayrollList(Payroll payroll)
    {
        return payrollMapper.selectPayrollList(payroll);
    }

    /**
     * 新增薪资管理
     * 
     * @param payroll 薪资管理
     * @return 结果
     */
    @Override
    public int insertPayroll(Payroll payroll)
    {
        return payrollMapper.insertPayroll(payroll);
    }

    /**
     * 修改薪资管理
     * 
     * @param payroll 薪资管理
     * @return 结果
     */
    @Override
    public int updatePayroll(Payroll payroll)
    {
        return payrollMapper.updatePayroll(payroll);
    }

    /**
     * 批量删除薪资管理
     * 
     * @param ids 需要删除的薪资管理主键
     * @return 结果
     */
    @Override
    public int deletePayrollByIds(Long[] ids)
    {
        return payrollMapper.deletePayrollByIds(ids);
    }

    /**
     * 删除薪资管理信息
     * 
     * @param id 薪资管理主键
     * @return 结果
     */
    @Override
    public int deletePayrollById(Long id)
    {
        return payrollMapper.deletePayrollById(id);
    }
}
