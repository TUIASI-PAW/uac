package ro.h23.uac;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ro.h23.uac.example.AuthenticationExample;
import ro.h23.uac.example.JPAExample;

// https://spring.io/guides/gs/relational-data-access/
//@Sql({"/sqls/user_schema.sql"})

@SpringBootApplication
public class UACApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UACApplication.class);

	public static void main(String args[]) {
		SpringApplication.run(UACApplication.class, args);
	}

	//@Autowired
	//private JDBCExample jdbcExample;
	
	//@Autowired
	//private JPAExample jpaExample;
	
	@Autowired
	private AuthenticationExample authenticationExample;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
		log.info("Hello World!!!");
		//jdbcExample.run();	
		//jpaExample.run();
		authenticationExample.run();
				
	}

}