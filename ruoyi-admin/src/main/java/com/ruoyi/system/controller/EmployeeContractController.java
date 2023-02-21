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
import com.ruoyi.system.domain.EmployeeContract;
import com.ruoyi.system.service.IEmployeeContractService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 奖惩管理Controller
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
@RestController
@RequestMapping("/system/contract")
public class EmployeeContractController extends BaseController
{
    @Autowired
    private IEmployeeContractService employeeContractService;

    /**
     * 查询奖惩管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:contract:list')")
    @GetMapping("/list")
    public TableDataInfo list(EmployeeContract employeeContract)
    {
        startPage();
        List<EmployeeContract> list = employeeContractService.selectEmployeeContractList(employeeContract);
        return getDataTable(list);
    }

    /**
     * 导出奖惩管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:contract:export')")
    @Log(title = "奖惩管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EmployeeContract employeeContract)
    {
        List<EmployeeContract> list = employeeContractService.selectEmployeeContractList(employeeContract);
        ExcelUtil<EmployeeContract> util = new ExcelUtil<EmployeeContract>(EmployeeContract.class);
        util.exportExcel(response, list, "奖惩管理数据");
    }

    /**
     * 获取奖惩管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:contract:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(employeeContractService.selectEmployeeContractById(id));
    }

    /**
     * 新增奖惩管理
     */
    @PreAuthorize("@ss.hasPermi('system:contract:add')")
    @Log(title = "奖惩管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EmployeeContract employeeContract)
    {
        return toAjax(employeeContractService.insertEmployeeContract(employeeContract));
    }

    /**
     * 修改奖惩管理
     */
    @PreAuthorize("@ss.hasPermi('system:contract:edit')")
    @Log(title = "奖惩管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EmployeeContract employeeContract)
    {
        return toAjax(employeeContractService.updateEmployeeContract(employeeContract));
    }

    /**
     * 删除奖惩管理
     */
    @PreAuthorize("@ss.hasPermi('system:contract:remove')")
    @Log(title = "奖惩管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(employeeContractService.deleteEmployeeContractByIds(ids));
    }
}
