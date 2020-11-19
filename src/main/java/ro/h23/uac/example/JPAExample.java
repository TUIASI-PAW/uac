package ro.h23.uac.example;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.h23.uac.model.User;
import ro.h23.uac.repository.UserRepository;

@Component
public class JPAExample {

	private static final Logger log = LoggerFactory.getLogger(JPAExample.class);

	@Autowired
	private UserRepository userRepository;

	public void run() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<User>();
		userList.add(new User(0, "ana", "mere", "ana@nomail.com"));
		userList.add(new User(0, "vlaicu", "avion", "vlaicu@nomail.com"));
		
		for(User user : userList) {
			log.info("Inserting user record: {}", user);
			userRepository.save(user);
		}
	}
}
