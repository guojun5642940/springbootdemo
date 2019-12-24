package com.guoj.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.guoj.common.entity.vo.Result;
import com.guoj.common.exception.ErrorType;
import com.guoj.mapper.SysUserMapper;
import com.guoj.model.SysUser;
import com.guoj.model.User;
import com.guoj.service.SysUserService;
import com.guoj.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;

/**
 * @author guojun
 * @Title: SysUserServiceImpl
 * @ProjectName springbootdemo
 * @Description: TODO
 * @date 2019-12-1715:41
 */
@Service(value = "sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private TokenService tokenService;

    @Override
    public Result selectByPrimaryKey(Integer id) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
        return Result.success(sysUser);
    }

    @Override
    public Result findByUserName(String userName) {
        SysUser sysUser = sysUserMapper.findByUserName(userName);
        return Result.success(sysUser);
    }

    @Override
    public Result verifyUser(SysUser sysUser) {
        SysUser targetUser = sysUserMapper.findByUserName(sysUser.getUserName());
        if(targetUser == null){
            return Result.fail(ErrorType.NO_USER_ERROR);
        }else if(!targetUser.getPassword().equals(sysUser.getPassword())){
            return Result.fail(ErrorType.ACCOUNT_EXCEPTION);
        }else{
            String token = tokenService.getToken(targetUser);
            JSONObject result = new JSONObject();
            result.put("token",token);
            result.put("user", targetUser);
            return Result.success(result);
        }
    }
}