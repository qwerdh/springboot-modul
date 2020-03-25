package com.cczu.ddd.controller;

import net.sf.json.JSONObject;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Queue;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ddd
 * @create 2020-03-20    20:41
 **/
@Controller
public class testcontroller {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    Queue queue;
    @Autowired
    RedisTemplate redisTemplate; // 专门用于处理k-v对
    //使用activemq横向消峰，
    /*但是引发一个问题，如何让客户端获得结果，因为处理情况是在消息队列完成的
    * 以上可以通过消息队列处理消息时，绑定id，再给redis中设定一个值来在一开始的请求方法中进行判断；
    * 但是以上又有问题，万一处理的慢，redis的值还未设置怎么半
    *
    * 引申问题，activemq崩了消息怎么办，怎么恢复，activemq最大并发是多少，连接池最多允许连接是多少
    *
    * 可以把数据放在redis中，引用多个消息队列处理
    * */
    @RequestMapping("/activemq")
    @ResponseBody
    public String active() throws InterruptedException {
        Date date=new Date();
        String msg=String.valueOf(date);
        jmsMessagingTemplate.convertAndSend(queue,msg);
      if(Integer.parseInt(redisTemplate.opsForValue().get("action").toString())==1){
          return "succes";
      }
      else{
          return "error";
      }
    }
    @JmsListener(destination = "${my_queue}")
    public void revice(){
        int num=Integer.parseInt(redisTemplate.opsForValue().get("people").toString());
        num--;
        redisTemplate.opsForValue().set("people",num);
        System.out.println(num+1);
        if(num>0){
            redisTemplate.opsForValue().set("action",1);
        }
        else{
            redisTemplate.opsForValue().set("action",0);
        }
    }
    @JmsListener(destination = "${my_queue}")
    public void revice2(){
        int num=Integer.parseInt(redisTemplate.opsForValue().get("people").toString());
        num--;
        redisTemplate.opsForValue().set("people",num);
        System.out.println(num+1);
        if(num>0){
            redisTemplate.opsForValue().set("action",1);
        }
        else{
            redisTemplate.opsForValue().set("action",0);
        }
    }
    @JmsListener(destination = "${my_queue}")
    public void revice3(){
        int num=Integer.parseInt(redisTemplate.opsForValue().get("people").toString());
        num--;
        redisTemplate.opsForValue().set("people",num);
        System.out.println(num+1);
        if(num>0){
            redisTemplate.opsForValue().set("action",1);
        }
        else{
            redisTemplate.opsForValue().set("action",0);
        }
    }
    @RequestMapping("/redis")
    @ResponseBody
    public String redis(){
        redisTemplate.opsForValue().set("action",0);
        redisTemplate.opsForValue().set("people",1000);
        redisTemplate.opsForValue().set("name","丁丁丁");
        System.out.println(" redisTemplate.opsForValue() = " +  redisTemplate.opsForValue().get("action"));
        System.out.println(" redisTemplate.opsForValue() = " +  redisTemplate.opsForValue().get("people"));
        System.out.println(" redisTemplate.opsForValue() = " +  redisTemplate.opsForValue().get("name"));
        return "succ";
    }
    @RequestMapping("/json")
    @ResponseBody
    public JSONObject select(@RequestBody String mapjson)throws IOException {
        //字符串编码修改，防止乱码			HttpServletResponse res,HttpServletRequest request
        JSONObject mapmap = JSONObject.fromObject(mapjson);
        JSONObject succes = new JSONObject();
        succes.put("message","succes");
        return succes;
    }
}
