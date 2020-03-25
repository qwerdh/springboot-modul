package com.cczu.ddd.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author ddd
 * @create 2020-03-10    11:15
 **/
//@Transactional(rollbackFor = Exception.class) 此为数据回滚，若public方法报错，则会回滚
@Service
public class OntimeService {
    Logger log= LoggerFactory.getLogger(getClass());

    @Scheduled(cron="0/5 * * * * *")
    public void schedul(){
        // 这个方法就可以实现每天定时检查数据，若发现不对的地方即可调用方法通知管理员。
//        log.info("操作类型:更新,这是定时info");
//        log.warn("操作类型:添加,这是定时warn");
//        log.error("操作类型:删除,这是定时error");

        System.out.println(System.getProperty("user.dir"));
    }
    /*
    *  second  minute, hour, day of month, month，week
    * and day of week.  e.g. {@code "0 * * * * MON-FRI"} means once per minute on
    * */
//    @Scheduled(cron="0 * * * * MON-FRI")
//    public void schedul(){
//        // 这个方法就可以实现每天定时检查数据，若发现不对的地方即可调用方法通知管理员。
//        System.out.println("这是一个定时方法~");
//
//    }

}
