package com.guoj.springbootdemo;

import com.guoj.common.config.RedisConfig;
import com.guoj.common.utils.RedisUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author guojun
 * @Title: Test
 * @ProjectName springbootdemo
 * @Description: TODO
 * @date 2019-11-2622:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class Test extends com.guoj.springbootdemo.SpringbootdemoApplicationTests {


    @Autowired
    private RedisConfig redisConfig;

    @org.junit.Test
    public void Test1(){
//        Result r = userService.selectByPrimaryKey(1);
//        System.out.println(JSONObject.toJSONString(r));
//        redisTemplate.opsForValue().set("345","guoj");

        RedisUtils.set("guojun","dashauibi");
    }
}