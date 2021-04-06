package com.ht.demo.electricitymeter.task;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ht.demo.electricitymeter.service.TaskService;


/**
 * 
	* @描述: 定时器
	* @作者 韩涛
	* @更新时间 2021年4月6日
 */
@Component
@EnableScheduling
public class ScheduleTask {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    @Autowired
    private TaskService taskService;

    /**
     * 
    	* @描述: 查询信息
    	* @param 参数
    	* @作者 韩涛
    	* @更新时间 2021年4月6日
     */
    @Scheduled(fixedDelay = 1000 * 1) //1秒一次
    public void queryInfo() {
    	taskService.queryInfo();
    }

    /**
     * 每小时记录
     */
    @Scheduled(cron = "0 0 0/1 * * ? *")
    public void record() {
    	logger.info("开始记录");
    	taskService.record();
    	logger.info("记录成功");
    }

  

}
