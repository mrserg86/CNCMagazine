package com.mrserg86.cncmagazine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
//@EnableScheduling
public class CncMagazineApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(CncMagazineApplication.class, args);
	}

}