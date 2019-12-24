package com.guoj.mapper;

import com.guoj.common.config.MybatisRedisCache;
import com.guoj.model.SysUser;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
@CacheNamespace(implementation = MybatisRedisCache.class)
public interface SysUserMapper {

    String PUBLIC_COLUMN = "id,user_name userName,password";
    String TABLE_NAME = "sys_user";

    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    @Select("select "+PUBLIC_COLUMN+" from "+TABLE_NAME+" where id = #{id}")
    SysUser selectByPrimaryKey(Integer id);

    @Select("select "+PUBLIC_COLUMN+" from "+TABLE_NAME+" where user_name = #{userName}")
    SysUser findByUserName(String username);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}