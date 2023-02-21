package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PerformanceMapper;
import com.ruoyi.system.domain.Performance;
import com.ruoyi.system.service.IPerformanceService;

/**
 * 业绩管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-20
 */
@Service
public class PerformanceServiceImpl implements IPerformanceService 
{
    @Autowired
    private PerformanceMapper performanceMapper;

    /**
     * 查询业绩管理
     * 
     * @param id 业绩管理主键
     * @return 业绩管理
     */
    @Override
    public Performance selectPerformanceById(Long id)
    {
        return performanceMapper.selectPerformanceById(id);
    }

    /**
     * 查询业绩管理列表
     * 
     * @param performance 业绩管理
     * @return 业绩管理
     */
    @Override
    public List<Performance> selectPerformanceList(Performance performance)
    {
        return performanceMapper.selectPerformanceList(performance);
    }

    /**
     * 新增业绩管理
     * 
     * @param performance 业绩管理
     * @return 结果
     */
    @Override
    public int insertPerformance(Performance performance)
    {
        return performanceMapper.insertPerformance(performance);
    }

    /**
     * 修改业绩管理
     * 
     * @param performance 业绩管理
     * @return 结果
     */
    @Override
    public int updatePerformance(Performance performance)
    {
        return performanceMapper.updatePerformance(performance);
    }

    /**
     * 批量删除业绩管理
     * 
     * @param ids 需要删除的业绩管理主键
     * @return 结果
     */
    @Override
    public int deletePerformanceByIds(Long[] ids)
    {
        return performanceMapper.deletePerformanceByIds(ids);
    }

    /**
     * 删除业绩管理信息
     * 
     * @param id 业绩管理主键
     * @return 结果
     */
    @Override
    public int deletePerformanceById(Long id)
    {
        return performanceMapper.deletePerformanceById(id);
    }
}
