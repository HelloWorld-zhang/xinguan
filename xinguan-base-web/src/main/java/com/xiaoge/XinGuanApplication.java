package com.xiaoge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication()
@MapperScan(value = "com.xiaoge.system.mapper")
@EnableSwagger2
public class XinGuanApplication {
    public static void main(String[] args) {
        SpringApplication.run(XinGuanApplication.class,args);
    }
}
