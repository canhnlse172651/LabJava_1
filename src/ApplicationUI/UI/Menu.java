package ApplicationUI.UI;

import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int choice = 0;
		do {
			System.out.println("-----MENU-----");
			System.out.println("1. Manage products");
			System.out.println("2. Manage Warehouse");
			System.out.println("3. Report");
			System.out.println("4. Save file");
			System.out.println("5. exit");
			System.out.println("Please enter your choice : ");

			choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1 -> {
				ProductMenu a = new ProductMenu();
				a.showMenu();
			}
			case 2 -> {
				WarehouseMenu b = new WarehouseMenu();
				b.showMenu();
			}

			case 3 -> {
				reportMenu c = new reportMenu();
				c.ShowMenu();

			}
			case 4 -> {
				FileMenu d = new FileMenu();
				d.showMenu();

			}

			}

		} while (choice != 5);

	}

}
