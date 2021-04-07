package com.ht.demo.electricitymeter.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.demo.electricitymeter.constant.InstrumentType;
import com.ht.demo.electricitymeter.dao.bean.CommonResult;
import com.ht.demo.electricitymeter.dao.bean.Instrument;
import com.ht.demo.electricitymeter.dao.bean.PD194EData;
import com.ht.demo.electricitymeter.dao.req.ReqOpenPort;
import com.ht.demo.electricitymeter.util.ByteUtils;
import com.ht.demo.electricitymeter.util.SerialPortManager;
import com.ht.demo.electricitymeter.util.StringUtil;

import gnu.io.PortInUseException;
import gnu.io.SerialPort;

@Service
public class CommService {
	 private static final Logger logger = LoggerFactory.getLogger(CommService.class);
	//端口
    private static SerialPort port = null;
    
    @Autowired
    private InstrumentAddressesService instrumentAddressesService;

   public SerialPort getPort() {
	   return port;
   }
   

    /**
     * 查询有效的com口
     */
    public List<String> findPorts(){
        return SerialPortManager.findPorts();
    }

    /**
     * 打开选中的com口，开始轮询各个电表的信息
     */
    public CommonResult<String> openPort(ReqOpenPort reqInfo) throws PortInUseException {
    	String portName = reqInfo.getPortName();
    	int baudrate = reqInfo.getBaudrate();
        CommonResult<String> result = new CommonResult<>();
        String message;
        String errorCode = "000";
        if(StringUtil.isNullOrEmpty(port)){
            port = SerialPortManager.openPort(portName,baudrate);
            message = "打开成功";
        }else{
            message = "已存在打开的端口";
            errorCode = "200";
        }

        // 添加串口监听
        SerialPortManager.addListener(port, new SerialPortManager.DataAvailableListener() {
            @Override
            public void dataAvailable() {
                byte[] data = null;
                try {
                    if (port == null) {
                    	logger.error("串口对象为空，监听失败！");
                        return ;
                    } else {
                        // 读取串口数据
                        data = SerialPortManager.readFromPort(port);
                        // 以十六进制的形式接收数据
                        String value = ByteUtils.byteArrayToHexString(data) ;
                        //将数据解析存入缓存中
                        parseData(value);
                    }
                } catch (Exception e) {
                    // 日志打印错误信息后退出系统
                	logger.error(e.getMessage());
                }
            }
        });
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
     * 解析
     */
    public void parseData(String data) {
        String address = data.substring(0,2);
        Instrument electricityInfo =TaskService.dataMap.get(address);//从缓存中获取对应地址的对象
        //根据地址仪表配置表判断属于哪一种仪表
        String type =instrumentAddressesService.getAddressTypeMap().get(address);
        String addressName = instrumentAddressesService.getAddressMap().get(address).getAddressName();
        if(InstrumentType.PD194E.equals(type)) {
        	PD194EData info = new PD194EData();
        	if (info!=null) {
        		info = (PD194EData)electricityInfo;
        	}
        	info.setAddressName(addressName);
        	String code = data.substring(2,4);
        	switch(code) {
        	case "01": parsePD194EData01(data,info);break;
        	case "02": parsePD194EData02(data,info);break;
        	case "03": parsePD194EData03(data,info); break;
        	}
        	electricityInfo = info;
        }
        TaskService.dataMap.put(address, electricityInfo);
    }

    /**
     *PD194E 数据解析  功能码01  继电器状态 只有3个继电器
     */
    public PD194EData parsePD194EData01(String data, PD194EData PD){
        String temp = data.substring(6,8);
        PD.parserelayData(temp);
        return PD;
    }

    /**
     * PD194E 数据解析  功能码02 读开关量输入状态 只有4个开关量
     */
    public PD194EData parsePD194EData02(String data, PD194EData PD){
        String temp = data.substring(6,8);
        PD.parseSwitchData(temp);
        return PD;
    }

    /**
     * PD194E 数据解析  功能码03 读寄存器数据
     */
    public PD194EData parsePD194EData03(String data, PD194EData PD){
        String temp = data.substring(6,data.length()-4);
        PD.parseData(temp);
        return PD;
    }


}
