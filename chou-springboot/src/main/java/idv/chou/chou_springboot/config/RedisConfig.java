package idv.chou.chou_springboot.config;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

	@Bean
    public CacheManager cacheManager(RedisConnectionFactory  factory) {
        RedisCacheConfiguration config =  RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(1));
        RedisCacheManager cacheManager =  RedisCacheManager.builder(factory).cacheDefaults(config).build();
        return cacheManager;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		 RedisTemplate<String, String> template = new RedisTemplate<>();
		 //使用序列化才能避免亂碼
		 RedisSerializer<String> redisSerializer = new StringRedisSerializer();
		 template.setConnectionFactory(factory);
		 //key序列化方式
		 template.setKeySerializer(redisSerializer);
		 //value序列化
		 template.setValueSerializer(redisSerializer);
		 //value hashmap序列化
		 template.setHashValueSerializer(redisSerializer);
		 //key haspmap序列化
		 template.setHashKeySerializer(redisSerializer);
		 //
		 return template;
    }
}
