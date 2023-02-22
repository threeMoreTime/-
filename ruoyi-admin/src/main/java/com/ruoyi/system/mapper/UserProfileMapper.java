package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UserProfile;

/**
 * 用户详细信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-22
 */
public interface UserProfileMapper 
{
    /**
     * 查询用户详细信息
     * 
     * @param id 用户详细信息主键
     * @return 用户详细信息
     */
    public UserProfile selectUserProfileById(Long id);

    /**
     * 查询用户详细信息列表
     * 
     * @param userProfile 用户详细信息
     * @return 用户详细信息集合
     */
    public List<UserProfile> selectUserProfileList(UserProfile userProfile);

    /**
     * 新增用户详细信息
     * 
     * @param userProfile 用户详细信息
     * @return 结果
     */
    public int insertUserProfile(UserProfile userProfile);

    /**
     * 修改用户详细信息
     * 
     * @param userProfile 用户详细信息
     * @return 结果
     */
    public int updateUserProfile(UserProfile userProfile);

    /**
     * 删除用户详细信息
     * 
     * @param id 用户详细信息主键
     * @return 结果
     */
    public int deleteUserProfileById(Long id);

    /**
     * 批量删除用户详细信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserProfileByIds(Long[] ids);
}
