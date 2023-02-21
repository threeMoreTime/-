package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Performance;
import com.ruoyi.system.service.IPerformanceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 业绩管理Controller
 * 
 * @author ruoyi
 * @date 2023-02-20
 */
@RestController
@RequestMapping("/system/performance")
public class PerformanceController extends BaseController
{
    @Autowired
    private IPerformanceService performanceService;

    /**
     * 查询业绩管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:performance:list')")
    @GetMapping("/list")
    public TableDataInfo list(Performance performance)
    {
        startPage();
        List<Performance> list = performanceService.selectPerformanceList(performance);
        return getDataTable(list);
    }

    /**
     * 导出业绩管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:performance:export')")
    @Log(title = "业绩管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Performance performance)
    {
        List<Performance> list = performanceService.selectPerformanceList(performance);
        ExcelUtil<Performance> util = new ExcelUtil<Performance>(Performance.class);
        util.exportExcel(response, list, "业绩管理数据");
    }

    /**
     * 获取业绩管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:performance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(performanceService.selectPerformanceById(id));
    }

    /**
     * 新增业绩管理
     */
    @PreAuthorize("@ss.hasPermi('system:performance:add')")
    @Log(title = "业绩管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Performance performance)
    {
        return toAjax(performanceService.insertPerformance(performance));
    }

    /**
     * 修改业绩管理
     */
    @PreAuthorize("@ss.hasPermi('system:performance:edit')")
    @Log(title = "业绩管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Performance performance)
    {
        return toAjax(performanceService.updatePerformance(performance));
    }

    /**
     * 删除业绩管理
     */
    @PreAuthorize("@ss.hasPermi('system:performance:remove')")
    @Log(title = "业绩管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(performanceService.deletePerformanceByIds(ids));
    }
}
