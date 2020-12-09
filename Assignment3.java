/**
 * 
 */
package com.coderscampus.Assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author jkirkish
 *
 */
public class Assignment3 {

	public static User[] users = new User[4];
	static private UserService userService = new UserService();

	public static void main(String[] args) throws IOException {
		putUsersIntoArray();
		Scanner scanner1 = new Scanner(System.in);
		try {

			boolean authenticated = false;
			for (int loginTries = 0; loginTries < 5; loginTries++) {

				if (!authenticated)
					System.out.println("Enter your email:");
				String username = scanner1.nextLine();
				System.out.println("Enter your password: ");
				String password = scanner1.nextLine();

				User registeredUser = userService.isValidUser(username, password);

				if (registeredUser != null) {
					System.out.println("Welcome: " + registeredUser.getName());
					authenticated = true;
					break;
				} else {
					System.out.println("Invalid login, please try again");
					if (loginTries >= 4) {
						System.out.println("Too many failed login attempts, you are now locked out.");
						System.out.println("loginsAttempts " + (loginTries + 1));
					}
				}
			}
		} finally {
			if (scanner1 != null)
				scanner1.close();
		}

	}

	private static void putUsersIntoArray() {

		Scanner input = new Scanner(System.in);
		try {

			File file = new File("data.txt");

			input = new Scanner(file);
			String line = null;
			int i = 0;
			while (input.hasNextLine()) {
				line = input.nextLine();
				/*
				 * users[i] = new User(line.split(",")); i++;
				 * -------------------------------------
				 */
				System.out.println(line);
				String[] props = line.split(",");
				User user = new User();
				user.setUsername(props[0]);
				user.setPassword(props[1]);
				user.setName(props[2]);
				users[i] = new User(user.getUsername(), user.getPassword(), user.getName());
				i++;

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}

}
