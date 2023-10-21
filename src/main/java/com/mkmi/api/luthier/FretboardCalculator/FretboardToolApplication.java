package com.mkmi.api.luthier.FretboardCalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mkmi.api.luthier.FretboardCalculator.controller")
public class FretboardToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(FretboardToolApplication.class, args);
	}

}
