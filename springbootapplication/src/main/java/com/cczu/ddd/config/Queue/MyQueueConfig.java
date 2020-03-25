package com.cczu.ddd.config.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Queue;


/**
 * @author ddd
 * @create 2020-03-19    11:27
 **/
@Component
public class MyQueueConfig {
    @Value("${my_queue}")
    private  String MyQueue;
    // 将队列注入到springboot容器
    @Bean
    public Queue queue(){
        return new ActiveMQQueue(MyQueue);
    }

}
