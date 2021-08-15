package com.example.wizer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class WizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WizerApplication.class, args);
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> APPLICATION STARTED <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");


	}

}
