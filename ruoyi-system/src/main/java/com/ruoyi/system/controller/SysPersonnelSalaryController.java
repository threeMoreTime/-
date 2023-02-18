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
import com.ruoyi.system.domain.SysPersonnelSalary;
import com.ruoyi.system.service.ISysPersonnelSalaryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 薪资管理Controller
 *
 * @author ruoyi
 * @date 2022-11-13
 */
@RestController
@RequestMapping("/system/salary")
public class SysPersonnelSalaryController extends BaseController
{
    @Autowired
    private ISysPersonnelSalaryService sysPersonnelSalaryService;

    /**
     * 查询薪资管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:salary:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysPersonnelSalary sysPersonnelSalary)
    {
        startPage();
        List<SysPersonnelSalary> list = sysPersonnelSalaryService.selectSysPersonnelSalaryList(sysPersonnelSalary);
        return getDataTable(list);
    }

    /**
     * 导出薪资管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:salary:export')")
    @Log(title = "薪资管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysPersonnelSalary sysPersonnelSalary)
    {
        List<SysPersonnelSalary> list = sysPersonnelSalaryService.selectSysPersonnelSalaryList(sysPersonnelSalary);
        ExcelUtil<SysPersonnelSalary> util = new ExcelUtil<SysPersonnelSalary>(SysPersonnelSalary.class);
        util.exportExcel(response, list, "薪资管理数据");
    }

    /**
     * 获取薪资管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:salary:query')")
    @GetMapping(value = "/{personId}")
    public AjaxResult getInfo(@PathVariable("personId") Long personId)
    {
        return AjaxResult.success(sysPersonnelSalaryService.selectSysPersonnelSalaryByPersonId(personId));
    }

    /**
     * 新增薪资管理
     */
    @PreAuthorize("@ss.hasPermi('system:salary:add')")
    @Log(title = "薪资管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPersonnelSalary sysPersonnelSalary)
    {
        return toAjax(sysPersonnelSalaryService.insertSysPersonnelSalary(sysPersonnelSalary));
    }

    /**
     * 修改薪资管理
     */
    @PreAuthorize("@ss.hasPermi('system:salary:edit')")
    @Log(title = "薪资管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPersonnelSalary sysPersonnelSalary)
    {
        return toAjax(sysPersonnelSalaryService.updateSysPersonnelSalary(sysPersonnelSalary));
    }

    /**
     * 删除薪资管理
     */
    @PreAuthorize("@ss.hasPermi('system:salary:remove')")
    @Log(title = "薪资管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{personIds}")
    public AjaxResult remove(@PathVariable Long[] personIds)
    {
        return toAjax(sysPersonnelSalaryService.deleteSysPersonnelSalaryByPersonIds(personIds));
    }
}
