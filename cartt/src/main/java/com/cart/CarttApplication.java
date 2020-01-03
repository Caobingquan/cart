package com.cart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Binquan.Cao
 */
@MapperScan("com.cart.mapper")
@SpringBootApplication
public class CarttApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarttApplication.class, args);
    }

}
