package com.ht.electricitymeter.dao.bean;

import lombok.Data;

/**
 * 统一返回bean，规范返回数据格式
 */
@Data
public class CommonResult<T> {
	private Integer code = 0; //api请求状态：0请求成功，-1请求失败
	private String errorCode; //错误码，前端一些特殊处理通过错误码实现
	private String message; //错误信息或提示信息
	private T data;
	
	public CommonResult() {
		
	}
	
	public CommonResult(Integer code, String errorCode, String message) {
		this.code = code;
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public CommonResult(T data) {
		this.data = data;
	}

}
