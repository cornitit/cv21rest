package fr.univrouen.cv21;

import org.apache.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class ProjetTp08Application {
	
	public static final org.apache.log4j.Logger logger = LogManager.getLogger(ProjetTp08Application.class); 
	
	public static void main(String[] args) {
		logger.info("démarrage de l'api rest full");
		SpringApplication.run(ProjetTp08Application.class, args);
	}

}
