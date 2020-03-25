package com.cczu.ddd.dao;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
* compoent添加组件到容器重
* @ConfigurationProperties(prefix = "Department") 注册bean id 为Department 若配置文件配置了值，会自动注入
* 默认从全局配置文件之中
* */
//@Component
//@PropertySource(value={"classpath:depart.properties"}) 从特殊文件中获取值
//@ConfigurationProperties(prefix = "Department")
@Configuration
public class Department {

    /*
    * @value("12344")
    * @value("${配置文件中的值}")
    * */
    private Integer id;
    private String departmentName;

    @Bean
    // @Scope("prototype")  多例
    // 默认单例
    public Employee getEmployeeMyself(){
        return new Employee();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
