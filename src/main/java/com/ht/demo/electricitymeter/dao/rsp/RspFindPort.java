package com.ht.demo.electricitymeter.dao.rsp;

import java.util.List;

import lombok.Data;

@Data
public class RspFindPort {
	private List<String> ports;//有效的端口
	private String port;//当前打开的端口
}
