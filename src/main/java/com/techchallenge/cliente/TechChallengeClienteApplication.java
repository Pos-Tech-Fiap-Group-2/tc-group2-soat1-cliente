package com.techchallenge.cliente;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class TechChallengeClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechChallengeClienteApplication.class, args);
	}

}
