package ro.h23.uac;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UACApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UACApplication.class);

	public static void main(String args[]) {
		SpringApplication.run(UACApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
		log.info("Hello World!!!");
	}

	
}