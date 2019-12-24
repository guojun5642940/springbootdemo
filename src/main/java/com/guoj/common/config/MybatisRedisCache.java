package com.guoj.common.config;

import com.guoj.common.utils.SpringUtil;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author guoj
 * @Title: MybatisRedisCache
 * @ProjectName zt
 * @Description: TODO
 * @date 2019/4/269:49
 */
public class MybatisRedisCache implements Cache{

    private String id;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public MybatisRedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    private RedisTemplate<Object, Object> getRedisTemplate(){
        return (RedisTemplate) SpringUtil.getBean("redisTemplate");
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.boundHashOps(getId()).put(key, value);
    }

    @Override
    public Object getObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        Object value = redisTemplate.boundHashOps(getId()).get(key);
        return value;
    }

    @Override
    public Object removeObject(Object key) {
        RedisTemplate redisTemplate = getRedisTemplate();
        Object value = redisTemplate.boundHashOps(getId()).delete(key);
        return value;
    }

    @Override
    public void clear() {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.delete(getId());
    }

    @Override
    public int getSize() {
        RedisTemplate redisTemplate = getRedisTemplate();
        Long size = redisTemplate.boundHashOps(getId()).size();
        return size == null ? 0 : size.intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
