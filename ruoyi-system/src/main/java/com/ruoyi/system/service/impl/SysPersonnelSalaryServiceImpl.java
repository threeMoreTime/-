package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysPersonnelSalaryMapper;
import com.ruoyi.system.domain.SysPersonnelSalary;
import com.ruoyi.system.service.ISysPersonnelSalaryService;

/**
 * 薪资管理Service业务层处理
 *
 * @author ruoyi
 * @date 2022-11-13
 */
@Service
public class SysPersonnelSalaryServiceImpl implements ISysPersonnelSalaryService
{
    @Autowired
    private SysPersonnelSalaryMapper sysPersonnelSalaryMapper;

    /**
     * 查询薪资管理
     *
     * @param personId 薪资管理主键
     * @return 薪资管理
     */
    @Override
    public SysPersonnelSalary selectSysPersonnelSalaryByPersonId(Long personId)
    {
        return sysPersonnelSalaryMapper.selectSysPersonnelSalaryByPersonId(personId);
    }

    /**
     * 查询薪资管理列表
     *
     * @param sysPersonnelSalary 薪资管理
     * @return 薪资管理
     */
    @Override
    public List<SysPersonnelSalary> selectSysPersonnelSalaryList(SysPersonnelSalary sysPersonnelSalary)
    {
        return sysPersonnelSalaryMapper.selectSysPersonnelSalaryList(sysPersonnelSalary);
    }

    /**
     * 新增薪资管理
     *
     * @param sysPersonnelSalary 薪资管理
     * @return 结果
     */
    @Override
    public int insertSysPersonnelSalary(SysPersonnelSalary sysPersonnelSalary)
    {
        sysPersonnelSalary.setCreateTime(DateUtils.getNowDate());
        return sysPersonnelSalaryMapper.insertSysPersonnelSalary(sysPersonnelSalary);
    }

    /**
     * 修改薪资管理
     *
     * @param sysPersonnelSalary 薪资管理
     * @return 结果
     */
    @Override
    public int updateSysPersonnelSalary(SysPersonnelSalary sysPersonnelSalary)
    {
        sysPersonnelSalary.setUpdateTime(DateUtils.getNowDate());
        return sysPersonnelSalaryMapper.updateSysPersonnelSalary(sysPersonnelSalary);
    }

    /**
     * 批量删除薪资管理
     *
     * @param personIds 需要删除的薪资管理主键
     * @return 结果
     */
    @Override
    public int deleteSysPersonnelSalaryByPersonIds(Long[] personIds)
    {
        return sysPersonnelSalaryMapper.deleteSysPersonnelSalaryByPersonIds(personIds);
    }

    /**
     * 删除薪资管理信息
     *
     * @param personId 薪资管理主键
     * @return 结果
     */
    @Override
    public int deleteSysPersonnelSalaryByPersonId(Long personId)
    {
        return sysPersonnelSalaryMapper.deleteSysPersonnelSalaryByPersonId(personId);
    }
}
