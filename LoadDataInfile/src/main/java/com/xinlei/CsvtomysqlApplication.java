package com.xinlei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.xinlei.mapper")
@EnableSwagger2
public class CsvtomysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsvtomysqlApplication.class, args);
    }

}
