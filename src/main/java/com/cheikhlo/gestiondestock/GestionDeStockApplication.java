package com.cheikhlo.gestiondestock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;


@SpringBootApplication
@EnableAutoConfiguration
public class GestionDeStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDeStockApplication.class, args);
	}

}
