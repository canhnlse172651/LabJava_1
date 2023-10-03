package ApplicationUI.uitilities;

import java.util.Scanner;

/**
 *
 * @author SwordLake
 */
public class DataInput {
	// -------------------------------------------------
	public static int getIntegerNumber(String displayMessage) {
		int number = 0;
		do {

			try {

				number = 0;
				String s;
				System.out.print(displayMessage);
				Scanner sc = new Scanner(System.in);
				s = sc.nextLine();
				if (!s.matches("\\d{1,10}")) {
					throw new Exception("Data invalid.");
				} else {
					number = Integer.parseInt(s);
				}
				break;

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} while (true);
		return number;
	}

	// ---------------------------------------------------
	public static int getIntegerNumber() throws Exception {
		int number = 0;
		String s;
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		if (!s.matches("\\d{1,10}")) {
			throw new Exception("Data invalid.");
		} else {
			number = Integer.parseInt(s);
		}
		return number;
	}

	// --------------------------------------------------
	public static String getString(String displayMessage) {
		String s;
		Scanner sc = new Scanner(System.in);
		System.out.print(displayMessage);
		s = sc.nextLine();
		return s;
	}

	// ---------------------------------------------------
	public static String getString() {
		String s;
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		return s;
	}
	// --------------------------------------------------
	// To do here..........
}
