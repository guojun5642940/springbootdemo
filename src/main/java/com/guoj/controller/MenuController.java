package com.guoj.controller;

import com.guoj.common.annotation.UserLoginToken;
import com.guoj.common.entity.vo.Result;
import com.guoj.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guojun
 * @Title: MenuController
 * @ProjectName springbootdemo
 * @Description: TODO
 * @date 2019-12-0916:19
 */
@RestController
@Api("菜单相关")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @UserLoginToken
    @ApiOperation(value = "查询所有菜单",notes = "查询所有菜单")
    @PostMapping(value = "/query",produces = "application/json")
    public Result queryAllMenu(){
        Result result = menuService.SelectMenuList();
        return result;
    }
}