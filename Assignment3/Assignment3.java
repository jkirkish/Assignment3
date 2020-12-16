/**
 * 
 */
package com.coderscampus.Assignment3;

import java.io.BufferedReader;
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
	private static UserService userService = new UserService();
	private static int MAX_LOGIN_TRIES = 4;

	public static void main(String[] args) throws IOException {
		putUsersIntoArray();
		Scanner scanner = new Scanner(System.in);

		boolean authenticated = false;
		int loginTries = 0;
		while (loginTries < MAX_LOGIN_TRIES && !authenticated) {

			loginTries++;
			System.out.println("Enter your email:");
			String username = scanner.nextLine();
			System.out.println("Enter your password: ");
			String password = scanner.nextLine();

			User registeredUser = userService.isValidUser(username, password);

			if (registeredUser != null) {
				System.out.println("Welcome: " + registeredUser.getName());
				authenticated = true;
			} else {

				if (loginTries < MAX_LOGIN_TRIES) {
					System.out.println("Invalid login, please try again");
					// System.out.println("Too many failed login attempts, you are now locked
					// out.");

				}
			}
			if (!authenticated) {
				System.out.println("Too many failed login attempts, you are now locked out.");
			}
			scanner.close();
		}
	}

	private static void putUsersIntoArray() {

		BufferedReader reader = null;
		// Buffered reader is more efficient to read large lines csv files

		try {
			reader = new BufferedReader(new FileReader("data.txt"));
			String line = null;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				String[] props = line.split(",");
				System.out.println(line);
				users[i] = new User(props[0], props[1], props[2]);
				i++;
			}

		} catch (FileNotFoundException ex) {
			System.out.println("File not found! Please check file.");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Error has occured, Please checklogs");
			ex.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception ex) {
				System.out.println("Reader cannot be closed");
				ex.printStackTrace();
			}
		}
	}

}
