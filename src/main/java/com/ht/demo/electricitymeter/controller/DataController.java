package com.ht.demo.electricitymeter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ht.demo.electricitymeter.dao.bean.Instrument;
import com.ht.demo.electricitymeter.service.InstrumentAddressesService;
import com.ht.demo.electricitymeter.service.TaskService;


/**
 * 
	* @描述: 数据controller
	* @作者 韩涛
	* @更新时间 2021年4月7日
 */
@RestController
@RequestMapping("/data")
public class DataController {
	@Autowired
	private TaskService TaskService;
	@Autowired
	private InstrumentAddressesService  instrumentAddressesService;
	
	/**
	 * 
		* @描述: 获取实时信息
		* @param @return参数
		* @作者 韩涛
		* @更新时间 2021年4月7日
	 */
	 @RequestMapping("getInfo")
    public List<Instrument> getInfo(){
        return TaskService.getInfo();
    }
	 
	 //获取仪表类型
	 
	 //获取线路信息
	 
	 //修改线路信息 不做
	 
	 //新增线路信息 不做
	 
	 //获取记录的信息
}
