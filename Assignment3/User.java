/**
 * 
 */
package com.coderscampus.Assignment3;

/**
 * @author kirkish
 * POJO(Plain old Java Object)
 */
public class User {
	
	String username;
	String password;
	String name;
	
	public User(String user, String pass, String name) {
		this.username = user;
		this.password = pass;
		this.name = name;
	}
	public User() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
