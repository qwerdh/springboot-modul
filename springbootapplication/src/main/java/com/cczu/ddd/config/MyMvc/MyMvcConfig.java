package com.cczu.ddd.config.MyMvc;

import com.cczu.ddd.config.Handle.LoginHandle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @author ddd
 * @create 2020-03-03    15:37
 * 自定义mvc配置，扩展springmvc的功能，通过重写需要添加的功能的方法
 **/
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器发送请求跳转特定界面，如果没有返回数据，就不用在controller里面写空方法了
        registry.addViewController("/").setViewName("index");

    }
    @Bean  //加到容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // 浏览器发送请求跳转特定界面，如果没有返回数据，就不用在controller里面写空方法了
                registry.addViewController("/index").setViewName("index");
            }
            // 添加拦截器 添加拦截器的地址以及排除拦截的信息
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // 添加拦截器
                registry.addInterceptor(new LoginHandle()).addPathPatterns("/**")
                        .excludePathPatterns("/","/login","/verifyCode","/activemq","/redis");

            }
        };

        return adapter;
    }



}
