package com.ht.demo.electricitymeter.dao.req;

import lombok.Data;

@Data
public class ReqOpenPort {
	private String portName; 
	private Integer baudrate;
}
