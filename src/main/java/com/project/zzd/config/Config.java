package com.project.zzd.config;

import com.project.zzd.entiy.FaultQuery;
import io.rebloom.client.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;

@Configuration
public class Config {

    @Bean
    public RedisTemplate<String, List> redisTemplate(){
        RedisTemplate<String, List> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
//        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    @Bean
    public RedisTemplate<String, FaultQuery> queryRedisTemplate(){
        RedisTemplate<String, FaultQuery> queryRedisTemplate = new RedisTemplate<>();
        queryRedisTemplate.setConnectionFactory(jedisConnectionFactory());
//        queryRedisTemplate.setConnectionFactory(lettuceConnectionFactory);
        queryRedisTemplate.setKeySerializer(new StringRedisSerializer());
        return queryRedisTemplate;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    @Bean
    public QueryKeyGenerator queryKeyGenerator(){
        return new QueryKeyGenerator();
    }

    @Bean
    public Client reBloomClient(){
        return new Client("localhost",6379);
    }
}
