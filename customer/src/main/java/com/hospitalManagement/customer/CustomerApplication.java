package com.hospitalManagement.customer;

import com.hospitalManagement.customer.entity.CustomerRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CustomerApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(CustomerApplication.class, args);
		CustomerRepo customerRepo=context.getBean(CustomerRepo.class);
	}

}
