package com.cczu.ddd.config.Queue.topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

/**
 * @author ddd
 * @create 2020-03-19    11:57
 **/
@Component
public class MyTopicConfigure {
    @Value("${my_topic}")
    private String topic;
    @Bean
    public Topic topic(){
        return new ActiveMQTopic(topic);
    }
}
