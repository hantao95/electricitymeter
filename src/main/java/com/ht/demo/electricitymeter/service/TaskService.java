package com.ht.demo.electricitymeter.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ht.demo.electricitymeter.dao.bean.ElectricityInfo;

//TODO

/**
 * 定时任务
 * 每个一小时数据记录进数据库
 * 每3秒刷新一次缓存
 * 使用 ScheduledExecutorService 实现
 */
@Service
public class TaskService {
	/**
     * 静态变量当缓存，串口监听修改此变量，前端请求仅返回会此变量的值，不会发送请求
     */
    private static Map<Integer,ElectricityInfo> map = new HashMap();
    
    /**
     * 
    	* @描述: 发送报文，获取信息
    	* @param 参数
    	* @作者 韩涛
    	* @更新时间 2021年4月6日
     */
    public void queryInfo() {
    	
    }
    
    /**
     * 
    	* @描述: 将信息记录数据库
    	* @param 参数
    	* @作者 韩涛
    	* @更新时间 2021年4月6日
     */
    public void record(){
    	
    }
}
