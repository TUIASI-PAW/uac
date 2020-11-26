package ro.h23.uac.example;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import ro.h23.uac.model.User;

@Component
public class JDBCExample {

	private static final Logger log = LoggerFactory.getLogger(JDBCExample.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void run() {
		jdbcTemplate.execute("DROP TABLE IF EXISTS user");
		jdbcTemplate.execute("CREATE TABLE user(id SERIAL, username VARCHAR(30), password VARCHAR(255), email VARCHAR(255))");

		List<User> userList = new ArrayList<User>();
		userList.add(new User(0, "ana", "mere", "ana@nomail.com"));
		userList.add(new User(0, "vlaicu", "avion", "vlaicu@nomail.com"));

		List<Object[]> userPropertiesList = new ArrayList<Object[]>();
		userList.forEach(user -> userPropertiesList.add(user.toObjectArray()));
		userList.forEach(user -> log.info("Inserting user record: {}", user));

		// [ ["ana", "mere", "ana@nomail.com"], ["vlaicu", "avion", "vlaicu@nomail.com"] ]
		
		jdbcTemplate.batchUpdate("INSERT INTO user(username, password, email) VALUES (?,?, ?)", userPropertiesList);

		log.info("Querying for user records where username = 'Ana':");
		jdbcTemplate.query("SELECT id, username, password, email FROM user WHERE username=?", new Object[] { "ana" }, 
				(rs, rowNum) -> 
					new User(rs.getLong("id"), rs.getString("username"), rs.getString("password"), rs.getString("email")))
				.forEach(user -> log.info(user.toString()));
	}

}
