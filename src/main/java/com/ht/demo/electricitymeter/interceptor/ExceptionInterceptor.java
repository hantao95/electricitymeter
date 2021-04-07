package com.ht.demo.electricitymeter.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ht.demo.electricitymeter.dao.bean.AlertException;
import com.ht.demo.electricitymeter.dao.bean.CommonResult;



@RestControllerAdvice
public class ExceptionInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionInterceptor.class);
	
	/**
	 * 请求参数校验异常处理
	 * 丁晓忠
	 */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public <T> CommonResult<T> validationBodyException(MethodArgumentNotValidException exception){

        BindingResult result = exception.getBindingResult();
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            ObjectError error = errors.get(0);
            return new CommonResult<T>(-1, "0001",error.getDefaultMessage());
        }else {
        	return new CommonResult<T>(-1, "0001","操作异常");
        }
    }
	
	/**
     * 全局异常处理
	 * 丁晓忠
     */
	@ExceptionHandler
    public <T> CommonResult<T> handleException(HttpServletRequest request, HttpServletResponse response, final Exception e) {
        if (e instanceof AlertException) {//可以在前端Alert的异常
        	return new CommonResult<T>(-1, ((AlertException) e).getErrorCode(), 
        			((AlertException) e).getMessage());
		}else {//其它异常
			logger.error(e.getMessage(), e);
        	return new CommonResult<T>(-1, "0001","操作异常");
        }
    }
	
}
