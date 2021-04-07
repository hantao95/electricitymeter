package com.ht.demo.electricitymeter.dao.bean;

/**
 * 全局异常信息bean，可在service层抛出
 * 丁晓忠
 */
public class AlertException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String errorCode;//错误码，前端一些特殊处理通过错误码实现
	private String message;//错误信息或提示信息
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AlertException(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}
	
}
