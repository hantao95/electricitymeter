package com.ht.demo.electricitymeter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.demo.electricitymeter.dao.bean.InstrumentAddress;
import com.ht.demo.electricitymeter.dao.bean.InstrumentType;
import com.ht.demo.electricitymeter.dao.mapper.InstrumentAddressMapper;
import com.ht.demo.electricitymeter.dao.mapper.InstrumentTypeMapper;

/**
 * 
	* @描述: InstrumentAddresses 服务，同时缓存InstrumentAddresses和InstrumentType表
	* @作者 韩涛
	* @更新时间 2021年4月7日
 */
@Service
public class InstrumentAddressesService {
	//key id value 类型
	private static Map<Integer, String> typeMap = new HashMap<>();
	//key 地址 value 类型
	private static Map<String, String> addressTypeMap = new HashMap<>();
	//key 地址 value 线路名称
	private static Map<String, InstrumentAddress> addressMap = new HashMap<>();
	
	@Autowired
	private InstrumentAddressMapper instrumentAddressMapper;
	@Autowired
	private InstrumentTypeMapper instrumentTypeMapper;
	
	public  Map<Integer, String> getTypeMap() {
		if(typeMap.isEmpty()) {
			reflush();
		}
		return typeMap;
	}
	public  Map<String, String> getAddressTypeMap() {
		if(addressTypeMap.isEmpty()) {
			reflush();
		}
		return addressTypeMap;
	}
	
	public  Map<String, InstrumentAddress> getAddressMap() {
		if(addressMap.isEmpty()) {
			reflush();
		}
		return addressMap;
	}
	//刷新缓存
	public  void reflush() {
		List<InstrumentType> instrumentTypeList=instrumentTypeMapper.selectAll();
		for(InstrumentType type:instrumentTypeList) {
			typeMap.put(type.getId(), type.getName());
		}
		List<InstrumentAddress> instrumentAddressList=instrumentAddressMapper.selectAll();
		for(InstrumentAddress instrumentAddress:instrumentAddressList) {
			addressTypeMap.put(instrumentAddress.getAddress(), typeMap.get(instrumentAddress.getType()));
			addressMap.put(instrumentAddress.getAddress(), instrumentAddress);
		}
	}
	
	//获取类型
	public List<InstrumentType> queryInstrumentType(){
		List<InstrumentType> list = typeMap.entrySet().stream().map(e->{
			InstrumentType temp = new InstrumentType() ;
			temp.setId(e.getKey());
			temp.setName(e.getValue());
			return temp;
		}).collect(Collectors.toList());
		return list;
	}
	
	//获取线路信息
	public List<InstrumentAddress> queryInstrumentAddress(){
		List<InstrumentAddress> list = addressMap.entrySet().stream().map(e->e.getValue()).collect(Collectors.toList());
		return list;
	}
}
