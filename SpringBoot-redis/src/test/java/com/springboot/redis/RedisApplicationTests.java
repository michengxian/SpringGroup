package com.springboot.redis;

import com.springboot.redis.pojo.UserBean;
import com.springboot.redis.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;


    @Autowired
    private RedisUtils redisUtils;

    @Test
    void contextLoads() {
        boolean exits = redisTemplate.hasKey("test01");
        if (exits){
            String test01 = String.valueOf(redisTemplate.opsForValue().get("test01"));
            System.out.println(test01);
        }
        else {
            System.out.println("test01不存在");
            redisTemplate.opsForValue().set("test02","456");
            String test02 = String.valueOf(redisTemplate.opsForValue().get("test02"));
            System.out.println(test02);
            System.out.println("test02:"+test02);
        }
        System.out.println(exits);
    }


    @Test
    public void testRedis01(){
        UserBean bean = new UserBean("米",18);
        String jsonString = JSON.toJSONString(bean);
        redisTemplate.opsForValue().set("user",bean);
        String redisValue = String.valueOf(redisTemplate.opsForValue().get("user"));
        System.out.println(redisValue);
    }


    @Test
    public void testRedis02() {

        redisUtils.set("mi","123456");

        if (redisUtils.hasKey("mi")){
            System.out.println(redisUtils.get("mi"));
        }
    }

}
