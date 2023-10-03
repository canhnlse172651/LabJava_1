package ApplicationUI.uitilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {
	static Scanner sc = new Scanner(System.in);

	public boolean checkYesOrNo(String msg) {
		while (true) {
			String input = checkString(msg, null);
			if (input.equalsIgnoreCase("Y")) {
				return true;
			} else if (input.equalsIgnoreCase("N")) {
				return false;
			} else {
				System.err.println("Must input Y or N to select option");
				continue;
			}
		}
	}

	public static String checkString(String msg, String status) {
		// vong lap su dung de nguoi dung nhap den khi dung
		while (true) {
			System.out.println(msg);
			// allow user input a string
			String input_raw = sc.nextLine();
			if (status.equals("update") && input_raw.isBlank()) {
				return input_raw;
			}
			// input == null or do dai = 0 => rong
			if (input_raw == null || input_raw.length() == 0) {
				// error
				System.err.println("Must input a string not empty !!!");
				System.out.println("Please enter again!");
				continue;
			}
			return input_raw;
		}
	}

	public static int beforeDay(String day1, String day2) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date date1 = dateFormat.parse(day1);
			Date date2 = dateFormat.parse(day2);

			return date1.compareTo(date2);

		} catch (ParseException e) {
			System.out.println("Format this day Invalid dd/mm/yyyy.");
		}
		return 0;
	}

	public static String validDay() {

		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false); // Tắt tính linh hoạt để kiểm tra ngày hợp lệ chặt chẽ.

		boolean isValidDate = false;
		Date ngay = null;

		while (!isValidDate) {
			System.out.print("Enter day following format (dd/mm/yyyy) : ");
			String ngayNhap = scanner.nextLine();

			try {
				ngay = dateFormat.parse(ngayNhap);
				isValidDate = true;
			} catch (ParseException e) {
//		                throw new IllegalArgumentException("Day not validation ");
				System.out.println("Day Invalid ! please Enter again");

			}
		}

		return dateFormat.format(ngay);
	}

	public static String inputCode() {
		boolean tmp = false;
		String input=null;
		do {
			 try {
				 Scanner scanner = new Scanner(System.in);
			     System.out.print("Enter code following  by format (pxxxxx): ");
			      input = scanner.nextLine().toUpperCase();

			     if (isValidCode(input,"^P\\d{5}")) {
			         tmp = false;

			     } else {
			         throw new Exception();
			     }
			 }catch(Exception e) {
				 System.out.println("Wrong format code please enter again ");
				 tmp = true;
			 }
		}while(tmp);
		return input;
	 }

	public static boolean isValidCode(String input, String pattern) {
		return input.matches(pattern);
	}

	public static String checkName() {
		Scanner scanner = new Scanner(System.in);
		String name;
		boolean tmp = false;
		do {
			System.out.println("enter name :");
			name = sc.nextLine();
			if(!(name.isBlank())) {
				tmp = false;
			}else {
				System.out.println("name is empty please enter again");
				tmp = true;
			}
		}while(tmp);
		return name;
	}

}
