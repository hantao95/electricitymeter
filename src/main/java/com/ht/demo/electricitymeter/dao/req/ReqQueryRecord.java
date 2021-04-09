package com.ht.demo.electricitymeter.dao.req;

import com.ht.demo.electricitymeter.dao.base.ExportExcelReq;

import lombok.Data;

@Data
public class ReqQueryRecord extends ExportExcelReq {
	private String address ;//路线地址
	private String startDate;//开始日期
	private String endDate;//结束日期
}
