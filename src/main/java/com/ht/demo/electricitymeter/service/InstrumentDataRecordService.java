package com.ht.demo.electricitymeter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht.demo.electricitymeter.dao.bean.Instrument;
import com.ht.demo.electricitymeter.dao.bean.InstrumentDataRecord;
import com.ht.demo.electricitymeter.dao.mapper.InstrumentDataRecordMapper;

@Service
public class InstrumentDataRecordService {
	@Autowired
	private InstrumentDataRecordMapper instrumentDataRecordMapper;
	
	public List<Instrument> queryDataRecord(){
		List<InstrumentDataRecord> recordList = instrumentDataRecordMapper.selectAll();
		List<Instrument> result = new ArrayList<>();
		recordList.forEach(a->{
			
		});
		return result;
	}
}
