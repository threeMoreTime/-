package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Performance;

/**
 * 业绩管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-20
 */
public interface PerformanceMapper 
{
    /**
     * 查询业绩管理
     * 
     * @param id 业绩管理主键
     * @return 业绩管理
     */
    public Performance selectPerformanceById(Long id);

    /**
     * 查询业绩管理列表
     * 
     * @param performance 业绩管理
     * @return 业绩管理集合
     */
    public List<Performance> selectPerformanceList(Performance performance);

    /**
     * 新增业绩管理
     * 
     * @param performance 业绩管理
     * @return 结果
     */
    public int insertPerformance(Performance performance);

    /**
     * 修改业绩管理
     * 
     * @param performance 业绩管理
     * @return 结果
     */
    public int updatePerformance(Performance performance);

    /**
     * 删除业绩管理
     * 
     * @param id 业绩管理主键
     * @return 结果
     */
    public int deletePerformanceById(Long id);

    /**
     * 批量删除业绩管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePerformanceByIds(Long[] ids);
}
