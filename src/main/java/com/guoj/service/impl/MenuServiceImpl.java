package com.guoj.service.impl;

import com.guoj.common.entity.vo.Result;
import com.guoj.mapper.MenuMapper;
import com.guoj.model.Menu;
import com.guoj.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guojun
 * @Title: MenuServiceImpl
 * @ProjectName springbootdemo
 * @Description: TODO
 * @date 2019-12-0916:12
 */
@Service(value = "menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Result SelectMenuList() {
        List<Menu> menuList = menuMapper.SelectMenuList();
        return Result.success(menuList);
    }
}