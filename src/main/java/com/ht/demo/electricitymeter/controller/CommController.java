package com.ht.demo.electricitymeter.controller;

import com.ht.demo.electricitymeter.dao.bean.CommonResult;
import com.ht.demo.electricitymeter.dao.bean.PD194EData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * 通讯control
 */
@RestController
@RequestMapping("/comm")
public class CommController {

    /**
     * 查询有效的com口
     */


    /**
     * 打开选中的com口，开始轮询各个电表的信息
     */

    /**
     * 关闭com口
     */

    /**
     * 获取信息
     */
    @RequestMapping("getMessage")
    public CommonResult getMessage(){
        List<PD194EData> list = new ArrayList<>();
        PD194EData date = new PD194EData();
        list.add(date);
        CommonResult commonResult = new CommonResult(list);
        return commonResult;
    }





}
