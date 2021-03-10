package com.ht.demo.electricitymeter.config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ht.demo.electricitymeter.interceptor.TokenInterceptor;




public class MyConfigure implements WebMvcConfigurer {
	 private TokenInterceptor tokenInterceptor;

	    //构造方法
	    public MyConfigure(TokenInterceptor tokenInterceptor){
	        this.tokenInterceptor = tokenInterceptor;
	    }

	    /**
	     * 跨域
	     */
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	                .allowCredentials(true)
	                .allowedHeaders("*")
	                .allowedMethods("*")
	                .allowedOrigins("*");
	    }

	    @Override
	    public void configureAsyncSupport(AsyncSupportConfigurer configurer){
	        configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3)));
	        configurer.setDefaultTimeout(30000);
	    }

	    /**
	         * 拦截器配置
	     */
	    @Override
	    public void addInterceptors(InterceptorRegistry registry){
	        List<String> excludePath = new ArrayList<>();
	        //排除拦截
	        excludePath.add("/platform/user/erpLogin");  //登录
	        excludePath.add("/platform/user/updatePassword"); //改密码
	        excludePath.add("/platform/user/checkRegister");  //注册
	        excludePath.add("/platform/file/upload");  //图片上传
	        excludePath.add("/platform/common/sendSmsCode");  //发送短信验证码
	        excludePath.add("/platform/common/checkSmsCode"); //校验验证码
	        excludePath.add("/platform/common/retrievePassword"); //短信找回修改密码
	        excludePath.add("/platform/common/queryBaseAreaList");
	        excludePath.add("/platform/common/getServiceTel");
	        
	        //app
	        excludePath.add("/app/common/my/checkVersionUpgrade");  //app更新
	        excludePath.add("/app/common/user/appLogin");
	        excludePath.add("/app/common/user/queryAppIsAudit");//查询app是否在审核
	        excludePath.add("/app/common/user/register");//app注册
	        excludePath.add("/app/common/user/checkRegister");
	        excludePath.add("/app/common/user/queryUserAgreement");  //查询app用户协议/隐私政策
	        excludePath.add("/app/common/appCommon/getServiceTel");  //app获取客服电话
	        
	        excludePath.add("/swagger-resources/**");
	        excludePath.add("/webjars/**");
	        excludePath.add("/v2/**");
	        excludePath.add( "/swagger-ui.html/**");
	        excludePath.add( "/doc.html/**");
	        registry.addInterceptor(tokenInterceptor)
	                .addPathPatterns("/**")
	                .excludePathPatterns(excludePath);
	        WebMvcConfigurer.super.addInterceptors(registry);
	    }
}
