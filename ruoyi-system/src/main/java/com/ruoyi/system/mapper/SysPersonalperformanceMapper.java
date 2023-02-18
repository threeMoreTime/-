package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysPersonalperformance;
import org.apache.ibatis.annotations.Mapper;

/**
 * 业绩管理Mapper接口
 *
 * @author ruoyi
 * @date 2022-11-15
 */
@Mapper
public interface SysPersonalperformanceMapper
{
    /**
     * 查询业绩管理
     *
     * @param personalId 业绩管理主键
     * @return 业绩管理
     */
    public SysPersonalperformance selectSysPersonalperformanceByPersonalId(Long personalId);

    /**
     * 查询业绩管理列表
     *
     * @param sysPersonalperformance 业绩管理
     * @return 业绩管理集合
     */
    public List<SysPersonalperformance> selectSysPersonalperformanceList(SysPersonalperformance sysPersonalperformance);

    /**
     * 新增业绩管理
     *
     * @param sysPersonalperformance 业绩管理
     * @return 结果
     */
    public int insertSysPersonalperformance(SysPersonalperformance sysPersonalperformance);

    /**
     * 修改业绩管理
     *
     * @param sysPersonalperformance 业绩管理
     * @return 结果
     */
    public int updateSysPersonalperformance(SysPersonalperformance sysPersonalperformance);

    /**
     * 删除业绩管理
     *
     * @param personalId 业绩管理主键
     * @return 结果
     */
    public int deleteSysPersonalperformanceByPersonalId(Long personalId);

    /**
     * 批量删除业绩管理
     *
     * @param personalIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysPersonalperformanceByPersonalIds(Long[] personalIds);
}
