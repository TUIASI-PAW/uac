package ro.h23.uac.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.h23.uac.model.User;
import ro.h23.uac.repository.UserRepository;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;

	// http://localhost:8080/users
	@GetMapping(path = "", produces = "application/json")
	public List<User> getUsers() {
		log.info("User list: " + userRepository.findAll().toString());
		List<User> result = new ArrayList<User>();
		userRepository.findAll().forEach(result::add); // <=> x -> result.add(x)
		return result;
	}
}