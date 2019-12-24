package com.guoj.common.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * @author guoj
 * @Title: RedisConfig
 * @ProjectName zt
 * @Description: redis配置
 * @date 2019/4/269:46
 */
@Data
@Configuration
public class RedisConfig {

    @Value("${spring.redis.hostName}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Value("${spring.redis.timeout}")
    private int redisTimeout;

    @Value("${spring.redis.password}")
    private String redisAuth;

    @Value("${spring.redis.database}")
    private int redisDb;

    @Value("${spring.redis.maxActive}")
    private int maxActive;

    @Value("${spring.redis.max-wait}")
    private int maxWait;

    @Value("${spring.redis.maxIdle}")
    private int maxIdle;

    @Value("${spring.redis.minIdle}")
    private int minIdle;

    @Bean
    public RedisConnectionFactory connectionFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMaxWaitMillis(maxWait);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(false);
        poolConfig.setTestWhileIdle(true);
        JedisClientConfiguration clientConfig = JedisClientConfiguration.builder()
                .usePooling().poolConfig(poolConfig).and().readTimeout(Duration.ofMillis(redisTimeout)).build();

        // 单点redis
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        // 哨兵redis
        // RedisSentinelConfiguration redisConfig = new RedisSentinelConfiguration();
        // 集群redis
        // RedisClusterConfiguration redisConfig = new RedisClusterConfiguration();
        redisConfig.setHostName(redisHost);
        redisConfig.setPassword(RedisPassword.of(redisAuth));
        redisConfig.setPort(redisPort);
        redisConfig.setDatabase(redisDb);
        return new JedisConnectionFactory(redisConfig,clientConfig);
    }

    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        // key采用Jackson2JsonRedisSerializer的序列化方式
        template.setKeySerializer(jackson2JsonRedisSerializer);
        // hash的key也采用Jackson2JsonRedisSerializer的序列化方式
        template.setHashKeySerializer(jackson2JsonRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
