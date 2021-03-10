package com.ht.demo.electricitymeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.ht.electricitymeter.dao")
@EnableSwagger2
@SpringBootApplication
public class ElectricitymeterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElectricitymeterApplication.class, args);
    }

}
