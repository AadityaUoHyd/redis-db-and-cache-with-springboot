package org.aadi.poc.redis_db_springboot_demo.config;

import org.aadi.poc.redis_db_springboot_demo.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

	@Bean
	public RedisConnectionFactory cf() {
		return new LettuceConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, Person> redisTemplate(){
		RedisTemplate<String, Person> template = new RedisTemplate<>();
		template.setConnectionFactory(cf());
		return template;
	}
}