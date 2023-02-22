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
import com.ruoyi.system.domain.UserProfile;
import com.ruoyi.system.service.IUserProfileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户详细信息Controller
 * 
 * @author ruoyi
 * @date 2023-02-22
 */
@RestController
@RequestMapping("/system/profile")
public class UserProfileController extends BaseController
{
    @Autowired
    private IUserProfileService userProfileService;

    /**
     * 查询用户详细信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:profile:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserProfile userProfile)
    {
        startPage();
        List<UserProfile> list = userProfileService.selectUserProfileList(userProfile);
        return getDataTable(list);
    }

    /**
     * 导出用户详细信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:profile:export')")
    @Log(title = "用户详细信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserProfile userProfile)
    {
        List<UserProfile> list = userProfileService.selectUserProfileList(userProfile);
        ExcelUtil<UserProfile> util = new ExcelUtil<UserProfile>(UserProfile.class);
        util.exportExcel(response, list, "用户详细信息数据");
    }

    /**
     * 获取用户详细信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:profile:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userProfileService.selectUserProfileById(id));
    }

    /**
     * 新增用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:profile:add')")
    @Log(title = "用户详细信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserProfile userProfile)
    {
        return toAjax(userProfileService.insertUserProfile(userProfile));
    }

    /**
     * 修改用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:profile:edit')")
    @Log(title = "用户详细信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserProfile userProfile)
    {
        return toAjax(userProfileService.updateUserProfile(userProfile));
    }

    /**
     * 删除用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:profile:remove')")
    @Log(title = "用户详细信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userProfileService.deleteUserProfileByIds(ids));
    }
}
