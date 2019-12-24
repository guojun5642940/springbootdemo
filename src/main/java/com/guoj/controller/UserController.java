package com.guoj.controller;

import com.guoj.common.entity.vo.Result;
import com.guoj.model.SysUser;
import com.guoj.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@Api("用户相关")
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(value = "查询用户",notes = "根据id查询用户")
    @PostMapping(value = "/query/{id}",produces = "application/json")
    public Result queryUser(@PathVariable String id){
        Result result = sysUserService.selectByPrimaryKey(Integer.parseInt(id));
        return result;
    }

    @ApiOperation(value = "登陆", notes = "登陆")
    @RequestMapping(value = "/verifyUser" ,method = RequestMethod.GET)
    public Result verifyUser(SysUser user, HttpServletResponse response) {
        return sysUserService.verifyUser(user);
    }
}
