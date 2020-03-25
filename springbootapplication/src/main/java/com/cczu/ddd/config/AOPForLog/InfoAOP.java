package com.cczu.ddd.config.AOPForLog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author ddd
 * @create 2020-03-25    16:43
 **/
@Aspect //当前类为切面类
public class InfoAOP {
    // 在切面类里面写需要切入的方法
    @Pointcut(value = "execution(public void com.cczu.ddd.service.OntimeService.*(..))")
    public void pointCut(){}
    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("joinPoint.getSignature().getName() = " + joinPoint.getSignature().getName());
        System.out.println("joinPoint = " + joinPoint.getArgs());
}
    @After(value = "pointCut()")
    public void After(JoinPoint joinPoint){
    }
    // 这样可以获得返回值，并且joinPoint必须在参数第一位
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterreturn(JoinPoint joinPoint,Object result){
        System.out.println("result = " + result);
    }
}
