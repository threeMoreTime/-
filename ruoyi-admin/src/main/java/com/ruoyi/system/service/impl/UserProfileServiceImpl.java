package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserProfileMapper;
import com.ruoyi.system.domain.UserProfile;
import com.ruoyi.system.service.IUserProfileService;

/**
 * 用户详细信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-22
 */
@Service
public class UserProfileServiceImpl implements IUserProfileService 
{
    @Autowired
    private UserProfileMapper userProfileMapper;

    /**
     * 查询用户详细信息
     * 
     * @param id 用户详细信息主键
     * @return 用户详细信息
     */
    @Override
    public UserProfile selectUserProfileById(Long id)
    {
        return userProfileMapper.selectUserProfileById(id);
    }

    /**
     * 查询用户详细信息列表
     * 
     * @param userProfile 用户详细信息
     * @return 用户详细信息
     */
    @Override
    public List<UserProfile> selectUserProfileList(UserProfile userProfile)
    {
        return userProfileMapper.selectUserProfileList(userProfile);
    }

    /**
     * 新增用户详细信息
     * 
     * @param userProfile 用户详细信息
     * @return 结果
     */
    @Override
    public int insertUserProfile(UserProfile userProfile)
    {
        return userProfileMapper.insertUserProfile(userProfile);
    }

    /**
     * 修改用户详细信息
     * 
     * @param userProfile 用户详细信息
     * @return 结果
     */
    @Override
    public int updateUserProfile(UserProfile userProfile)
    {
        return userProfileMapper.updateUserProfile(userProfile);
    }

    /**
     * 批量删除用户详细信息
     * 
     * @param ids 需要删除的用户详细信息主键
     * @return 结果
     */
    @Override
    public int deleteUserProfileByIds(Long[] ids)
    {
        return userProfileMapper.deleteUserProfileByIds(ids);
    }

    /**
     * 删除用户详细信息信息
     * 
     * @param id 用户详细信息主键
     * @return 结果
     */
    @Override
    public int deleteUserProfileById(Long id)
    {
        return userProfileMapper.deleteUserProfileById(id);
    }
}
