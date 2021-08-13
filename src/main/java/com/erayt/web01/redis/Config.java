package com.erayt.web01.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @Auther: Z151
 * @Date: 2021/8/13 16:21
 */
//打开该注释的话，需要启动redis服务。
//@Configuration
public class Config {

    @Bean
    public RedisMessageRceiver redisMessageRceiver(){
        return new RedisMessageRceiver();
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(RedisMessageRceiver redisMessageRceiver) {
        return new MessageListenerAdapter(redisMessageRceiver, "myMessageReceiver");
    }

    @Bean
    public StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory,
                                                                       MessageListenerAdapter listenerAdapter){
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        redisMessageListenerContainer.addMessageListener(listenerAdapter,new PatternTopic("chat"));
        return redisMessageListenerContainer;

    }



}
