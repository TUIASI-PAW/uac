package ro.h23.uac.model;

import javax.persistence.*;

// https://www.codejava.net/frameworks/spring-boot/spring-boot-security-role-based-authorization-tutorial

//javax.persistence.* <= spring-boot-starter-data-jpa
@Entity // hibernate will create a table out of this class
//@Table(name = "\"user\"")
public class User {

	@Id
	//@Column(name = "user_id")
	@Column(name ="id")
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

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, username=%s, password=%s, email=%s]", id, username, password, email);
	}

}
