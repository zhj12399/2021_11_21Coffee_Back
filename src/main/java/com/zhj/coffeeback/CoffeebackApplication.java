package com.zhj.coffeeback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhj.coffeeback.mapper")
public class CoffeebackApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CoffeebackApplication.class, args);
    }
}
