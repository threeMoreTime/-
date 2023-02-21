package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EmployeeContractMapper;
import com.ruoyi.system.domain.EmployeeContract;
import com.ruoyi.system.service.IEmployeeContractService;

/**
 * 奖惩管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
@Service
public class EmployeeContractServiceImpl implements IEmployeeContractService 
{
    @Autowired
    private EmployeeContractMapper employeeContractMapper;

    /**
     * 查询奖惩管理
     * 
     * @param id 奖惩管理主键
     * @return 奖惩管理
     */
    @Override
    public EmployeeContract selectEmployeeContractById(Long id)
    {
        return employeeContractMapper.selectEmployeeContractById(id);
    }

    /**
     * 查询奖惩管理列表
     * 
     * @param employeeContract 奖惩管理
     * @return 奖惩管理
     */
    @Override
    public List<EmployeeContract> selectEmployeeContractList(EmployeeContract employeeContract)
    {
        return employeeContractMapper.selectEmployeeContractList(employeeContract);
    }

    /**
     * 新增奖惩管理
     * 
     * @param employeeContract 奖惩管理
     * @return 结果
     */
    @Override
    public int insertEmployeeContract(EmployeeContract employeeContract)
    {
        return employeeContractMapper.insertEmployeeContract(employeeContract);
    }

    /**
     * 修改奖惩管理
     * 
     * @param employeeContract 奖惩管理
     * @return 结果
     */
    @Override
    public int updateEmployeeContract(EmployeeContract employeeContract)
    {
        return employeeContractMapper.updateEmployeeContract(employeeContract);
    }

    /**
     * 批量删除奖惩管理
     * 
     * @param ids 需要删除的奖惩管理主键
     * @return 结果
     */
    @Override
    public int deleteEmployeeContractByIds(Long[] ids)
    {
        return employeeContractMapper.deleteEmployeeContractByIds(ids);
    }

    /**
     * 删除奖惩管理信息
     * 
     * @param id 奖惩管理主键
     * @return 结果
     */
    @Override
    public int deleteEmployeeContractById(Long id)
    {
        return employeeContractMapper.deleteEmployeeContractById(id);
    }
}
