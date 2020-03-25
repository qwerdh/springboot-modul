package com.cczu.ddd.config.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @author ddd
 * @create 2020-03-19    11:33
 **/
@Component
public class MessProduce {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired  // 默认回去找我们注入的queue
    private Queue queue;

    @Scheduled(fixedDelay = 5000)   // 5秒
    public void sendmess(){
        String mes=System.currentTimeMillis()+""; //获得当前时间
        // 这个方法就可以实现每天定时检查数据，若发现不对的地方即可调用方法通知管理员。
      //  System.out.println("采用点对点通信模式，mes =  "+mes);
       //jmsMessagingTemplate.convertAndSend(queue,mes);
    }
}
