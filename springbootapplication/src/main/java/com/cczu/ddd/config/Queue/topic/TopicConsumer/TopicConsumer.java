package com.cczu.ddd.config.Queue.topic.TopicConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author ddd
 * @create 2020-03-19    12:04
 **/
@Component
public class TopicConsumer {
    @Autowired
    JavaMailSenderImpl javaMailSender;

    Logger log= LoggerFactory.getLogger(getClass());
    @JmsListener(destination = "${my_topic}")
    public void mailcomplx(String msg) throws MessagingException {
        System.out.println("topic msg = " + msg);
        MimeMessage message=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setSubject(msg);
        // true 表示文本是html
        helper.setText("<h2 style='color:red'>这是一封测试的的高级邮件</h2>",true);
        helper.setTo("2271796149@qq.com");
        helper.setFrom("1329788326@qq.com");
        //String path = request.getSession().getServletContext().getRealPath("/")+"img/1.jpg";
        //System.out.println("path = " + path);
        // 上传文件
        javaMailSender.send(message);
    }
}
