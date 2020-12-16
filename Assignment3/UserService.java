/**
 * 
 */
package com.coderscampus.Assignment3;

/**
 * @author kirkish
 *
 */
public class UserService {
	
	User user = new User();
	
	public User isValidUser(String username,String password) 
	{
		for(User user : Assignment3.users) {
			if(user.getUsername().equalsIgnoreCase(username))
			if(user.getPassword().equals(password)){
			return user;	
			}
		}return null;
	}
	

}
