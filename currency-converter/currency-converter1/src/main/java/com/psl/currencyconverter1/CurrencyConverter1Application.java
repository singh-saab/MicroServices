package com.psl.currencyconverter1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConverter1Application {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverter1Application.class, args);
	}

}
