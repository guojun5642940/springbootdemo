package com.guoj.service;

import com.guoj.common.entity.vo.Result;
import com.guoj.model.SysUser;

/**
 * @author guojun
 * @className SysUserService
 * @description TODO
 * @date {DATE}{TIME}
 */
public interface SysUserService {

    Result selectByPrimaryKey(Integer id);

    Result findByUserName(String userName);

    Result verifyUser(SysUser sysUser);
}
