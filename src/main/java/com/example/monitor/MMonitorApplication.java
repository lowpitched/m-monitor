package com.example.monitor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
@MapperScan("com.example.monitor.dao")
public class MMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MMonitorApplication.class, args);
	}

}
