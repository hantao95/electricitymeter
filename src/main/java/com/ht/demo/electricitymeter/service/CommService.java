package com.ht.demo.electricitymeter.service;

import java.util.List;

import com.ht.demo.electricitymeter.dao.bean.CommonResult;
import com.ht.demo.electricitymeter.dao.bean.PD194EData;
import com.ht.demo.electricitymeter.util.SerialPortManager;
import com.ht.demo.electricitymeter.util.StringUtil;

import gnu.io.PortInUseException;
import gnu.io.SerialPort;

public class CommService {

    private static SerialPort port = null;

   

    /**
     * 查询有效的com口
     */
    public List<String> findPorts(){
        return SerialPortManager.findPorts();
    }

    /**
     * 打开选中的com口，开始轮询各个电表的信息
     */
    public CommonResult<String> openPort(String portName, int baudrate) throws PortInUseException {
        CommonResult result = new CommonResult<String>();
        String message;
        String errorCode = "000";
        if(StringUtil.isNullOrEmpty(port)){
            port = SerialPortManager.openPort(portName,baudrate);
            message = "打开成功";
        }else{
            message = "已存在打开的端口";
            errorCode = "200";
        }
        result.setErrorCode(errorCode);
        result.setMessage(message);
       return result;
    }


    /**
     * 关闭com口
     */
    public void closePort(){
        SerialPortManager.closePort(port);
    }

    /**
     *  获取信息
     */

    /**
     *PD194E 数据解析  功能码01  继电器状态 只有3个继电器
     */
    public PD194EData parseData01(String data, PD194EData PD){
        String temp = data.substring(6,8);
        PD.parserelayData(temp);
        return PD;
    }

    /**
     * PD194E 数据解析  功能码02 读开关量输入状态 只有4个开关量
     */
    public PD194EData parseData02(String data, PD194EData PD){
        String temp = data.substring(6,8);
        PD.parseSwitchData(temp);
        return PD;
    }

    /**
     * PD194E 数据解析  功能码03 读寄存器数据
     */
    public PD194EData parseData03(String data, PD194EData PD){
        String temp = data.substring(6,data.length()-4);
        PD.parseData(temp);
        return PD;
    }


}
