package com.guoj.mapper;

import com.guoj.common.config.MybatisRedisCache;
import com.guoj.model.Menu;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface MenuMapper {

    String PUBLIC_COLUMN = "id,parent_id,menu_name,menu_url,menu_type,menu_click_count,menu_icon";
    String TABLE_NAME = "sys_menu";

    /**
     * 查询所有菜单
     * @return
     */
    @Results(id="menuMap",value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "menu_name", property = "menuName"),
            @Result(column = "menu_url", property = "menuUrl"),
            @Result(column = "menu_type", property = "menuType"),
            @Result(column = "menu_click_count", property = "menuClickCount"),
            @Result(column = "menu_icon", property = "menuIcon")
    })
    @Select("select "+PUBLIC_COLUMN+" from "+TABLE_NAME +" where canceled = '0' order by menu_sort")
    List<Menu> SelectMenuList();
}