package com.coderscampus.Assignment3;

import java.io.File;
import java.util.Scanner;

public class reading {

	public static void main(String[] args) {

		try {
			System.out.print("Enter the file name with extension : ");

			Scanner input = new Scanner(System.in);

			File file = new File("data.txt");

			input = new Scanner(file);

			while (input.hasNextLine()) {
				String line = input.nextLine();
				System.out.println(line);
			}
			input.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
