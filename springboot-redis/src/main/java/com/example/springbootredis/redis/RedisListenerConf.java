package com.example.springbootredis.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/7/1
 */
@Configuration
public class RedisListenerConf {
    @Bean
    MessageListenerAdapter listenerAdapter( ) {
        MessageListenerAdapter adapter = new MessageListenerAdapter(new RedisListener());
        return adapter;
    }

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);

        container.addMessageListener(listenerAdapter, new PatternTopic("*"));//订阅所有渠道  你也可以这样 new PatternTopic("A.*")订阅A下面的所有渠道
        return container;
    }

}
