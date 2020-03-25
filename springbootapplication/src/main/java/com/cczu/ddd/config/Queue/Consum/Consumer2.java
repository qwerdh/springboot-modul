package com.cczu.ddd.config.Queue.Consum;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author ddd
 * @create 2020-03-20    21:23
 **/
@Component
public class Consumer2 {
    private int i=0;
    // 幂等性
    //@JmsListener(destination = "${my_queue}")
    public void receive(String msg) {
        if (i++ < 10) {
            System.out.println("msg = " + msg+"   当前为2号消费者第  "+ i);
        }
        else{
            System.out.println("msg = " + msg);
        }
    }

}
