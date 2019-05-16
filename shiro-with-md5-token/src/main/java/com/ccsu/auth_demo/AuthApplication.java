package com.ccsu.auth_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @author wenzhenyu
 * @description 权限
 * @date 2019/5/15
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ccsu.auth_demo.mapper.*")
@EnableCaching
public class AuthApplication {

    public static void main(String[] args){
        SpringApplication.run(AuthApplication.class,args);
    }



//    //因为编码问题自己定义redis
//    @Bean
//    public RedisTemplate<Serializable, Serializable> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<Serializable, Serializable> redisTemplate = new RedisTemplate<Serializable, Serializable>();
//        redisTemplate.setConnectionFactory(factory);
//
//        //key序列化方式;（不然会出现乱码;）,但是如果方法上有Long等非String类型的话，会报类型转换错误；
//        //所以在没有自己定义key生成策略的时候，以下这个代码建议不要这么写，可以不配置或者自己实现ObjectRedisSerializer
//        //或者JdkSerializationRedisSerializer序列化方式;
//        RedisSerializer<String> redisSerializer = new StringRedisSerializer();//Long类型不可以会出现异常信息;
//        redisTemplate.setKeySerializer(redisSerializer);
//        redisTemplate.setHashKeySerializer(redisSerializer);
//        return redisTemplate;
//    }


}
