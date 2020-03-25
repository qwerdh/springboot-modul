package com.cczu.ddd.config.AOPForLog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ddd
 * @create 2020-03-25    16:39
 * 前置通知
 * 后置通知
 * 返回通知
 * 异常通知
 * 环绕通知
 * 在目标方法之前加上通知注解
 * 将切面类加和通知类要加到容器中
 **/
@Configuration
public class AroundAop {
    // 将切面类放入容器，并且被通知的类也需要是容器里面的bean
   @Bean
    public InfoAOP getInfoAop(){
       return new InfoAOP();
   }


}
