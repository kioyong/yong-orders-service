package com.yong.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
public class YongOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(YongOrdersApplication.class, args);
	}
}
