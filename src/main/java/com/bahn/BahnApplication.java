package com.bahn;

import com.bahn.dao.TrainDAO;
import com.bahn.dao.impl.TrainDAOImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.bahn", "com.bahn.dao" })
public class BahnApplication {

	public static void main(String[] args) {
		SpringApplication.run(BahnApplication.class, args);
//		ConfigurableApplicationContext ctx = SpringApplication.run(BahnApplication.class, args);

//
//		TrainDAO dao = ctx.getBean(TrainDAO.class);
//
//		System.out.println(dao.getAllTrains());
	}
}
