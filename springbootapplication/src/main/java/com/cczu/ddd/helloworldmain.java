package com.cczu.ddd;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author ddd
 * @create 2020-01-05    10:44
 **/
/*
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
    底层采用springmvc的configuration
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {
* */
//@ImportResource(locations = {"classpath:beans.xml"}) 可以加入配置文件
// springboot 不建议 建议全注解
// 来标注这是springboot的主程序
@EnableAspectJAutoProxy  // 开启注解环绕
@EnableScheduling   // 开启定时任务
@EnableAsync        // 开启异步方法
@MapperScan(basePackages="com.cczu.ddd.mapper")
@SpringBootApplication
@EnableJms//开启activemq
@EnableCaching  // 开启注解式缓存
public class helloworldmain {
/*
* 自动配置原理  加载主运行类后  开启自动配置功能
* @EnableAutoConfiguration
    开启自动配置
    里面有自动导入包的配置  autopconfigurationpackage 将springbootapplication所在包极其子包全部扫扫描
    *properties配置特定类的值，因为特定类上标注着@ConfigurationProperties(prefix = "spring.http.encoding")
    * 然后自动装配的容器类，将上面的配置类进行注入，
    * @EnableConfigurationProperties(HttpEncodingProperties.class) 意为启动特定类的（ConfigurationProperties）配置功能，将配置文件中的值映射注入
    * 通过构造器将配置类注入到当前类中
    *根据当前类的@ConditionalOnProperty(prefix = "spring.http.encoding", value = "enabled", matchIfMissing = true)
    * 验证条件满足的情况下，就会将容器中添加组件
    *
* */
    public static void main(String[] args) {
        //必须要运行springbootapplication注解的类  springboot应用
        SpringApplication.run(helloworldmain.class,args);
}
}
