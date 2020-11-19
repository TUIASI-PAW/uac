package ro.h23.uac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//javax.persistence.* <= spring-boot-starter-data-jpa
@Entity // hibernate will create a table out of this class
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String	username;
	private String	password;
	private String	email;

	public User(long id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Object[] toObjectArray() {
		return new Object[] { username, password, email };
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, username=%s, password=%s, email=%s]", id, username, password, email);
	}

}
