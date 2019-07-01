package com.example.springbootredis.redis;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/7/1
 */
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void set(String name,String value)
    {
        redisTemplate.opsForValue().set(name,value);
    }

    public void setObj(String name,Object obj)
    {
        redisTemplate.opsForValue().set(name, JSON.toJSONString(obj));
    }


    //设置有效期时间 默认秒
    public void set(String name,String value,int expire)
    {
        redisTemplate.opsForValue().set(name,value,expire,TimeUnit.SECONDS);
    }

    //设置有效期时间
    public void set(String name,String value,int expire,TimeUnit timeUnit)
    {
        redisTemplate.opsForValue().set(name,value,expire,timeUnit);
    }

    public String get(String name)
    {
        return redisTemplate.opsForValue().get(name);
    }


    //取对象
    public JSONObject getObj(String key){
        String str = redisTemplate.opsForValue().get(key);
        if(null == str || "".equals(str)){
            return null;
        }
        return JSON.parseObject(str);
    }

    //取对象
    public <T> T getObj(String key,Class<T> tClass){
        String str = redisTemplate.opsForValue().get(key);
        if(null == str || "".equals(str)){
            return null;
        }
        T obj = JSON.parseObject(str,tClass);
        return obj;
    }


    //增加步长
    public String setInc(String name,Long value)
    {
        if(null != value && value > 0){
            redisTemplate.boundValueOps(name).increment(value);//步长增加
        }
        return get(name);
    }

    //减少步长
    public String setDec(String name,Long value)
    {
        if(null != value && value < 0){
            redisTemplate.boundValueOps(name).increment(-value);//步长减少
        }
        return get(name);
    }


    public void delete(String name)
    {
        redisTemplate.delete(name);
    }


    //查询key是否存在
    public boolean hasKey(String name)
    {
        return redisTemplate.hasKey(name);
    }

    //发布消息
    public void sendMsg(String channel,Object message)
    {
        redisTemplate.convertAndSend(channel,message);
    }
}
