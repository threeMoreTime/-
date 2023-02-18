package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysPersonalperformanceMapper;
import com.ruoyi.system.domain.SysPersonalperformance;
import com.ruoyi.system.service.ISysPersonalperformanceService;

/**
 * 业绩管理Service业务层处理
 *
 * @author ruoyi
 * @date 2022-11-15
 */
@Service
public class SysPersonalperformanceServiceImpl implements ISysPersonalperformanceService
{
    @Autowired
    private SysPersonalperformanceMapper sysPersonalperformanceMapper;

    /**
     * 查询业绩管理
     *
     * @param personalId 业绩管理主键
     * @return 业绩管理
     */
    @Override
    public SysPersonalperformance selectSysPersonalperformanceByPersonalId(Long personalId)
    {
        return sysPersonalperformanceMapper.selectSysPersonalperformanceByPersonalId(personalId);
    }

    /**
     * 查询业绩管理列表
     *
     * @param sysPersonalperformance 业绩管理
     * @return 业绩管理
     */
    @Override
    public List<SysPersonalperformance> selectSysPersonalperformanceList(SysPersonalperformance sysPersonalperformance)
    {
        return sysPersonalperformanceMapper.selectSysPersonalperformanceList(sysPersonalperformance);
    }

    /**
     * 新增业绩管理
     *
     * @param sysPersonalperformance 业绩管理
     * @return 结果
     */
    @Override
    public int insertSysPersonalperformance(SysPersonalperformance sysPersonalperformance)
    {
        sysPersonalperformance.setCreateTime(DateUtils.getNowDate());
        return sysPersonalperformanceMapper.insertSysPersonalperformance(sysPersonalperformance);
    }

    /**
     * 修改业绩管理
     *
     * @param sysPersonalperformance 业绩管理
     * @return 结果
     */
    @Override
    public int updateSysPersonalperformance(SysPersonalperformance sysPersonalperformance)
    {
        sysPersonalperformance.setUpdateTime(DateUtils.getNowDate());
        return sysPersonalperformanceMapper.updateSysPersonalperformance(sysPersonalperformance);
    }

    /**
     * 批量删除业绩管理
     *
     * @param personalIds 需要删除的业绩管理主键
     * @return 结果
     */
    @Override
    public int deleteSysPersonalperformanceByPersonalIds(Long[] personalIds)
    {
        return sysPersonalperformanceMapper.deleteSysPersonalperformanceByPersonalIds(personalIds);
    }

    /**
     * 删除业绩管理信息
     *
     * @param personalId 业绩管理主键
     * @return 结果
     */
    @Override
    public int deleteSysPersonalperformanceByPersonalId(Long personalId)
    {
        return sysPersonalperformanceMapper.deleteSysPersonalperformanceByPersonalId(personalId);
    }
}
