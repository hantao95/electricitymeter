package com.ht.demo.electricitymeter.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ht.demo.electricitymeter.dao.bean.CommonResult;
import com.ht.demo.electricitymeter.dao.bean.PD194EData;
import com.ht.demo.electricitymeter.dao.req.ReqOpenPort;
import com.ht.demo.electricitymeter.dao.rsp.RspFindPort;
import com.ht.demo.electricitymeter.service.CommService;
import com.ht.demo.electricitymeter.util.StringUtil;

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
	public RspFindPort findPorts(){
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
    public PageInfo<PD194EData> getMessage( @RequestParam(value = "name", required = false) String name){
        List<PD194EData> list = new ArrayList<>();
        PD194EData data = new PD194EData();
        PD194EData data2 = new PD194EData();
        data2.setAddress("2");
        data2.setUab(BigDecimal.ONE);
        data2.setAddressName("1231");
        list.add(data);
        if(StringUtil.isNullOrEmpty(name)) {
        	list.add(data2);
        }
        PageHelper.startPage(0, 20);
        PageInfo<PD194EData> page = new PageInfo<>(list);
        return page;
    }





}
