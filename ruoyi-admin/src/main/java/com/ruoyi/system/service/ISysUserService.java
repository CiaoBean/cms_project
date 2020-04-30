package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.SysUserRole;

/**
 * 用户 业务层
 * 
 * @author ruoyi
 */
public interface ISysUserService
{


    public List<SysUser> selectByLoginNameAndPassword(String loginName,String password);

    /**
     * 根据条件分页查询用户列表
     * 
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectUserList(SysUser user);



    /**
     * 通过用户ID查询用户
     * 
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public SysUser selectUserById(Long userId);



    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteUserByIds(String ids) throws Exception;

    /**
     * 保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int insertUser(SysUser user);


    /**
     * 保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUser(SysUser user);

    /**
     * 修改用户详细信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUserInfo(SysUser user);


    /**
     * 修改用户密码信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int resetUserPwd(SysUser user);

    /**
     * 校验用户名称是否唯一
     * 
     * @param loginName 登录名称
     * @return 结果
     */
    public String checkLoginNameUnique(String loginName);

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkPhoneUnique(SysUser user);

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkEmailUnique(SysUser user);



    /**
     * 用户状态修改
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int changeStatus(SysUser user);
}
