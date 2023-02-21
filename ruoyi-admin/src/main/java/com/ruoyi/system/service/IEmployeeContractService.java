package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.EmployeeContract;

/**
 * 奖惩管理Service接口
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
public interface IEmployeeContractService 
{
    /**
     * 查询奖惩管理
     * 
     * @param id 奖惩管理主键
     * @return 奖惩管理
     */
    public EmployeeContract selectEmployeeContractById(Long id);

    /**
     * 查询奖惩管理列表
     * 
     * @param employeeContract 奖惩管理
     * @return 奖惩管理集合
     */
    public List<EmployeeContract> selectEmployeeContractList(EmployeeContract employeeContract);

    /**
     * 新增奖惩管理
     * 
     * @param employeeContract 奖惩管理
     * @return 结果
     */
    public int insertEmployeeContract(EmployeeContract employeeContract);

    /**
     * 修改奖惩管理
     * 
     * @param employeeContract 奖惩管理
     * @return 结果
     */
    public int updateEmployeeContract(EmployeeContract employeeContract);

    /**
     * 批量删除奖惩管理
     * 
     * @param ids 需要删除的奖惩管理主键集合
     * @return 结果
     */
    public int deleteEmployeeContractByIds(Long[] ids);

    /**
     * 删除奖惩管理信息
     * 
     * @param id 奖惩管理主键
     * @return 结果
     */
    public int deleteEmployeeContractById(Long id);
}
