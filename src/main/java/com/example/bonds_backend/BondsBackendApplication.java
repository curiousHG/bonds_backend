package com.example.bonds_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import logger
import org.slf4j.Logger;
@SpringBootApplication
public class BondsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BondsBackendApplication.class, args);
		// create logger
		Logger logger = org.slf4j.LoggerFactory.getLogger(BondsBackendApplication.class);
		// log message
		logger.info("Bonds Backend Application Started");
	}

}
