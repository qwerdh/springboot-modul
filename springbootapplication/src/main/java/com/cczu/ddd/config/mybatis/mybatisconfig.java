package com.cczu.ddd.config.mybatis;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ddd
 * @create 2020-01-11    19:41
 **/
@Configuration
public class mybatisconfig {

    // 开启 字段和参数匹配规则，custom_name   --->    customname  相同
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
         return new ConfigurationCustomizer(){
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
             configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
