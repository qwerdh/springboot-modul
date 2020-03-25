package com.cczu.ddd.config.Queue.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

/**
 * @author ddd
 * @create 2020-03-19    12:01
 **/
@Component
public class TopicProdeuce {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Topic topic;
//    @Scheduled(fixedDelay = 5000)   // 5秒
//    public void sendtopicmess(){
//        String mes=System.currentTimeMillis()+"这是topic"; //获得当前时间
//        // 这个方法就可以实现每天定时检查数据，若发现不对的地方即可调用方法通知管理员。
//        System.out.println("采用点对点通信模式，mes =  "+mes);
//        jmsMessagingTemplate.convertAndSend(topic,mes);
//    }

}
