package com.ht.electricitymeter.config;

import com.ht.electricitymeter.dao.bean.CommonResult;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 统一返回数据格式
 * 丁晓忠
 */
@EnableWebMvc
@Configuration
public class ReturnConfig {

    @RestControllerAdvice
    static class CommonResultResponseAdvice implements ResponseBodyAdvice<Object>{
        public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            return true;
        }

        public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
            if (body instanceof CommonResult){
                return body;
            }
            return new CommonResult<Object>(body);
        }
    }

}
