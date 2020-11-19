package ro.h23.uac.model;

public class User {

	private long id;
	private String username;
	private String password;
	private String email;

	public User(long id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, username=%s, password=%s, email=%s]", id, username, password, email);
	}

}
