package com.ht.demo.electricitymeter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ht.demo.electricitymeter.dao.bean.InstrumentDataRecord;
import com.ht.demo.electricitymeter.dao.mapper.InstrumentDataRecordMapper;
import com.ht.demo.electricitymeter.dao.req.ReqQueryRecord;
import com.ht.demo.electricitymeter.util.StringUtil;

import tk.mybatis.mapper.entity.Example;

@Service
public class InstrumentDataRecordService {
	@Autowired
	private InstrumentDataRecordMapper instrumentDataRecordMapper;
	@Autowired
	private InstrumentAddressesService instrumentAddressesService;
	
	/**
	 * 
		* @描述: 获取数据库数据
		* @param @return参数
		* @作者 韩涛
		* @更新时间 2021年4月9日
	 */
	public PageInfo<InstrumentDataRecord> queryDataRecord(ReqQueryRecord reqInfo){
		 PageHelper.startPage(reqInfo.getPageNum(), reqInfo.getPageSize());
		 Example example = new Example(InstrumentDataRecord.class);
		 Example.Criteria criteria = example.createCriteria();
		 if(!StringUtil.isNullOrEmpty(reqInfo.getAddress())) {
			 criteria.andEqualTo("address", reqInfo.getAddress());
		 }
		 if(!StringUtil.isNullOrEmpty(reqInfo.getStartDate())) {
			 criteria.andGreaterThan("createTime", reqInfo.getStartDate());
		 }
		 if(!StringUtil.isNullOrEmpty(reqInfo.getEndDate())) {
			 criteria.andLessThan("createTime", reqInfo.getStartDate());
		 }
		 List<InstrumentDataRecord> recordList = instrumentDataRecordMapper.selectByExample(example);
		recordList.forEach(a->translation(a));
		return new PageInfo<>(recordList);
	}
	
	//映射线路名
	private void translation(InstrumentDataRecord data) {
		data.setAddressName(instrumentAddressesService.getAddressMap().get(data.getAddress()).getAddressName());
	}
	
}
