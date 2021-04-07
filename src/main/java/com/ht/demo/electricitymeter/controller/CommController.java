package com.ht.demo.electricitymeter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ht.demo.electricitymeter.dao.bean.CommonResult;
import com.ht.demo.electricitymeter.dao.bean.PD194EData;
import com.ht.demo.electricitymeter.dao.req.ReqOpenPort;
import com.ht.demo.electricitymeter.service.CommService;

import gnu.io.PortInUseException;


/**
 * 通讯control
 */
@RestController
@RequestMapping("/comm")
public class CommController {
	
	@Autowired
	private CommService commService;

    /**
     * 查询有效的com口
     */
	@RequestMapping("findPorts")
	public List<String> findPorts(){
        return commService.findPorts();
    }


    /**
     * 打开选中的com口，开始轮询各个电表的信息
     * @throws PortInUseException 
     */
	@RequestMapping("openPort")
	public CommonResult<String>  openPort(@RequestBody ReqOpenPort reqInfo) throws PortInUseException {
		return commService.openPort(reqInfo);
	}

    /**
     * 关闭com口
     */
	@RequestMapping("closePort")
	 public void closePort(){
	 commService.closePort();
    }

    /**
     * 获取信息
     */
    @RequestMapping("getMessage")
    public List<PD194EData> getMessage(){
        List<PD194EData> list = new ArrayList<>();
        PD194EData date = new PD194EData();
        list.add(date);
        return list;
    }





}
