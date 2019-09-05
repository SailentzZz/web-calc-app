package Classes;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	private int id;
	
	@NotNull(message="Name has been input")
	@Size(min = 3, max = 12, message="Length name - max=12/min=3")
	@Pattern(regexp = "^[a-zA-Z0-9$@$!%*?&#^-_.+]+$", message = "Only english latters")
	private String name;
	
	@NotNull(message="Login has been input")
	@Size(min = 3, max = 16, message="Length login - max=16/min=3")
	@Pattern(regexp = "^[a-zA-Z0-9$@$!%*?&#^-_.+]+$", message = "Only english latters")
	private String logging;
	
	@NotNull(message="Password has been input")
	@Size(min = 3, max = 10, message="Length password - max=18/min=3")
	@Pattern(regexp = "^[a-zA-Z0-9$@$!%*?&#^-_.+]+$", message = "Only english latters")
	private String password;
	
	@NotNull(message="Email has been input")
	@Pattern(regexp = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)" +
	      "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)" +
	      "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)" +
	      "+(?:[a-zA-Z]){2,}\\.?)$", 
	      message = "Email not exist")
	private String email;
	
	public User(int id, String name, String logging, String password, String email) {
		this.id = id;
		this.name = name;
		this.logging = logging;
		this.password = password;
		this.email = email;
	}	

	public User() {}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLogging() {
		return logging;
	}
	public void setLogging(String logging) {
		this.logging = logging;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id = " + id + " | name = " + name + " | logging = " + logging + " | password = " + password + " | email = " + email;
	}
		
}
