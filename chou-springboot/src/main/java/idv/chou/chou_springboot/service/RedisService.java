package idv.chou.chou_springboot.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
	@Value("${redis.expireseconds}")
	private Long expireseconds;
	
	private RedisSerializer redisSerializer = new  StringRedisSerializer();
	
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    public void set(String key, Object value) {
        //更改在redis裡面檢視key編碼問題
    	redisinit(redisTemplate);
        ValueOperations<String, Object> vo =  redisTemplate.opsForValue();
        vo.set(key, value);
    }

    public Object get(String key) {
        ValueOperations<String, Object> vo =  redisTemplate.opsForValue();
        return vo.get(key);
    }
    
    public void lpush(String key, String value) {
    	redisinit(redisTemplate);
        redisTemplate.opsForList().leftPush(key, value);
        redisTemplate.expire(key, expireseconds, TimeUnit.SECONDS);
    }
    
    public void lpush(String key, String value, long expireseconds) {
    	redisinit(redisTemplate);
        redisTemplate.opsForList().leftPush(key, value);
        redisTemplate.expire(key, expireseconds, TimeUnit.SECONDS);
    }
    
    public Object index(String key, int index) {
        return redisTemplate.opsForList().index(key, index);
    }
    
    public List<Object> range(String key, int start, int end) {
        return redisTemplate.opsForList().range(key, start, end);
    }
    
    public int size(String key) {
        return redisTemplate.opsForList().size(key).intValue();
    }
    
    public void set(String key, Integer index, String value) {
        redisTemplate.opsForList().set(key, index, value);
    }
    
    public void remove(String key, String value, int count) {
        redisTemplate.opsForList().remove(key, count, value);
    }
    
    public void trim(String key, Integer start, Integer end) {
        redisTemplate.opsForList().trim(key, start, end);
    }
    
    public void redisinit(RedisTemplate redisTemplate) {
        redisTemplate.setKeySerializer(redisSerializer);
    }
}