package ro.h23.uac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// https://www.codejava.net/frameworks/spring-boot/spring-boot-security-role-based-authorization-tutorial

//javax.persistence.* <= spring-boot-starter-data-jpa
@Entity // hibernate will create a table out of this class
//@Table(name = "users")
public class User {

	@Id
	//@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String	username;
	private String	password;
	private String	email;

	// required for UserRepository @Query
	public User() {
	}
	//lombok
	public User(long id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	// we need public getters, otherwise @GetMapping return a list of empty objects
	
	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public Object[] toObjectArray() {
		return new Object[] { username, password, email };
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, username=%s, password=%s, email=%s]", id, username, password, email);
	}

}
