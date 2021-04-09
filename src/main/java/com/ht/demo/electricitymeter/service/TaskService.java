package com.ht.demo.electricitymeter.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.demo.electricitymeter.constant.InstrumentType;
import com.ht.demo.electricitymeter.constant.StartCode;
import com.ht.demo.electricitymeter.dao.bean.Instrument;
import com.ht.demo.electricitymeter.dao.bean.InstrumentDataRecord;
import com.ht.demo.electricitymeter.dao.mapper.InstrumentDataRecordMapper;
import com.ht.demo.electricitymeter.util.ByteUtils;
import com.ht.demo.electricitymeter.util.CRC16Util;
import com.ht.demo.electricitymeter.util.SerialPortManager;

import gnu.io.SerialPort;



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
     * key 仪表地址
     * value 信息
     */
    public static Map<String,Instrument> dataMap = new HashMap();
    @Autowired
    private CommService commService;
    @Autowired
    private InstrumentAddressesService instrumentAddressesService;
    @Autowired
    private InstrumentDataRecordMapper instrumentDataRecordMapper;
    
    /**
     * 
    	* @描述: 发送报文，获取信息
    	* @param 参数
    	* @作者 韩涛
    	* @更新时间 2021年4月6日
     */
    public void sendMessage() {
    	SerialPort port = commService.getPort();//获取端口
    	if(port==null) {
    		return;
    	}
    	//遍历地址
    	Map<String, String> instrumentAddresses=instrumentAddressesService.getAddressTypeMap();
    	for(Entry<String, String> entry:instrumentAddresses.entrySet()) {
    		if(InstrumentType.PD194E.equals(entry.getValue())) {
    			String address = entry.getKey();
    			List<byte[]> orderList = getPD194EMessage( address);
    			for (byte[] order : orderList) {
    				SerialPortManager.sendToPort(port, order);
    			}
    		}
    	}
    }
    
    /**
     * 
    	* @描述: 生成PD194E请求报文
    	* @param @param address
    	* @param @return参数
    	* @作者 韩涛
    	* @更新时间 2021年4月7日
     */
    private List<byte[]> getPD194EMessage(String address){
    	List<byte[]> result = new ArrayList<>();
    	byte[] code1 = ByteUtils.hexStr2Byte(CRC16Util.addCRC(address+StartCode.PD194E_01)) ;
    	byte[] code2 = ByteUtils.hexStr2Byte(CRC16Util.addCRC(address+StartCode.PD194E_02)) ;
    	byte[] code3 = ByteUtils.hexStr2Byte(CRC16Util.addCRC(address+StartCode.PD194E_03)) ;
    	result.add(code1);
    	result.add(code2);
    	result.add(code3);
    	return result;
    }
    
    /**
     * 
    	* @描述: 将信息记录数据库
    	* @param 参数
    	* @作者 韩涛
    	* @更新时间 2021年4月6日
     */
    public void record(){
    	for(Entry<String, Instrument> entry :dataMap.entrySet()) {
    		InstrumentDataRecord record = new InstrumentDataRecord();
    		BeanUtils.copyProperties(entry.getValue(), record);
    		instrumentDataRecordMapper.insertSelective(record);
    	}
    }
    
    /**
     * 
    	* @描述: 获取实时数据
    	* @param @return参数
    	* @作者 韩涛
    	* @更新时间 2021年4月7日
     */
    public List<Instrument> getInfo(){
    	List<Instrument> list = new ArrayList<>();
    	dataMap.forEach((k,v)->list.add(v));
    	return list;
    }
}
