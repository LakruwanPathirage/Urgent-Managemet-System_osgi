package essentialProductsManage;

import java.util.ArrayList;
import java.util.Scanner;

public class EssentialProductManagementImpl implements IEssentialProductManagement {

	private ArrayList<Product> budgetPack1500;
	private ArrayList<Product> budgetPack2500;
	private ArrayList<Product> budgetPack7500;

	public EssentialProductManagementImpl() {
		budgetPack2500 = new ArrayList<>();
		budgetPack1500 = new ArrayList<>();
		budgetPack7500 = new ArrayList<>();

		budgetPack1500.add(new Product("1001", "Nipuna Rice 10kg", 1300.0));
		budgetPack1500.add(new Product("1002", "Dhal 2kg", 400.0));
		budgetPack1500.add(new Product("1003", "Canned Fish 500g", 200.0));
		budgetPack1500.add(new Product("1004", "coconut powder 400g", 600.0));

		budgetPack2500.add(new Product("2001", "Nipuna Rice 5kg", 750.0));
		budgetPack2500.add(new Product("2002", "Dhal 1kg", 200.0));
		budgetPack2500.add(new Product("2003", "Canned Fish 250g", 100.0));
		budgetPack2500.add(new Product("2004", "coconut powder 200g", 450.0));

		budgetPack7500.add(new Product("3001", "Nipuna Rice 25kg", 2500.0));
		budgetPack7500.add(new Product("3002", "Dhal 5kg", 1000.0));
		budgetPack7500.add(new Product("3003", "Canned tuna Fish 1kg", 500.0));
		budgetPack7500.add(new Product("3004", "coconut powder 400g", 600.0));
		budgetPack7500.add(new Product("3005", "Vegetbale Pack", 2300.0));

	}

	@Override
	public int selectOptions() {
		int number = 0;

		while (number != 99) {

			System.out.println("1. Add Products To Budget Packs");
			System.out.println("2. Show Products");
			System.out.println("3. Update Products");
			System.out.println("4. Delete Products");
			System.out.println("0.Back");
			System.out.println("99.Exit");
			System.out.print("Select your task : ");

			Scanner in = new Scanner(System.in);
			number = in.nextInt();

			if (number == 0) {
				return number;
			}

			switch (number) {
			case 1:
				System.out.println("------Now you can add Products--------");
				System.out.println("1.Budget Pack 1500 Rs");
				System.out.println("2.Budget Pack 2500 Rs");
				System.out.println("3.Budget Pack 7500 Rs");
				System.out.println("-------------------------------------");
				System.out.println("Select pack:");
				int addPackTypeSelection = in.nextInt();

				String addPackType = "";

				if (addPackTypeSelection == 1) {
					addPackType = "Budget Pack 1500 Rs";
				} else if (addPackTypeSelection == 2) {
					addPackType = "Budget Pack 2500 Rs";
				} else if (addPackTypeSelection == 3) {
					addPackType = "Budget Pack 7500 Rs";
				} else {
					break;
				}
				String id = null;
				boolean validID = false;
				while (!validID) {
					System.out.println("Product ID:");
					id = in.next();
					in.nextLine();
					validID = this.checkID(id, addPackType);
					if (!validID) {
						System.out.println("!!!This ID Already in the system!!!");
					}
				}

				System.out.println("Product Name:");
				String pName = in.nextLine();
				System.out.println("Product Price:");
				double pPrice = in.nextDouble();
				this.addItem(id, pName, pPrice, addPackType);

				showPack(addPackType);

				break;

			case 2:

				showAllPacks();
				break;

			case 3:
				System.out.println("------Now you can update Products--------");

				System.out.println("1.Budget Pack 1500 Rs");
				System.out.println("2.Budget Pack 2500 Rs");
				System.out.println("3.Budget Pack 7500 Rs");
				System.out.println("-------------------------------------");
				System.out.println("Select Budget Pack:");
				int updatePackTypeSelection = in.nextInt();

				String updatePackType = "";

				if (updatePackTypeSelection == 1) {
					updatePackType = "Budget Pack 1500 Rs";
				} else if (updatePackTypeSelection == 2) {
					updatePackType = "Budget Pack 2500 Rs";
				} else if (updatePackTypeSelection == 3) {
					updatePackType = "Budget Pack 7500 Rs";
				} else {
					break;
				}

				String idu = null;
				boolean validIDu = true;
				while (validIDu) {
					System.out.println("Product ID:");
					idu = in.next();
					in.nextLine();
					validIDu = this.checkID(idu, updatePackType);
					if (validIDu) {
						System.out.println("!!!Cant Find Product with provided ID!!!");
					}
				}
				System.out.println("Product Name:");
				String pNameU = in.nextLine();
				System.out.println("Product Price:");
				double pPriceU = in.nextDouble();
				boolean result = this.updateProduct(idu, pNameU, pPriceU, updatePackType);
				if (result) {
					System.out.println("Successfully Updated.");
				} else {
					System.out.println("Update failed.");
				}

				showPack(updatePackType);

				break;

			case 4:

				System.out.println("------Now you can delete Products--------");

				System.out.println("1.Budget Pack 1500 Rs");
				System.out.println("2.Budget Pack 2500 Rs");
				System.out.println("3.Budget Pack 7500 Rs");
				System.out.println("-------------------------------------");
				System.out.println("Select Budget Pack:");

				int deletePackTypeSelection = in.nextInt();

				String deletePackType = "";

				if (deletePackTypeSelection == 1) {
					deletePackType = "Budget Pack 1500 Rs";
				} else if (deletePackTypeSelection == 2) {
					deletePackType = "Budget Pack 2500 Rs";
				} else if (deletePackTypeSelection == 3) {
					deletePackType = "Budget Pack 7500 Rs";
				} else {
					break;
				}
				String idd = null;

				boolean validIDd = true;
				while (validIDd) {
					System.out.println("Product ID:");
					idd = in.next();
					in.nextLine();
					validIDd = this.checkID(idd, deletePackType);
					if (validIDd) {
						System.out.println("!!!Cant Find Product with provided ID!!!");
					}
				}
				boolean resultDel = this.removeProduct(idd, deletePackType);
				if (resultDel) {
					System.out.println("Successfully Deleted.");
				} else {
					System.out.println("Delete failed.");
				}

				showPack(deletePackType);
				break;

			case 99:

				return number;
			default:
				System.out.println("!!!  Wrong Input .. Exiting... !!! ");
				break;
			}

			System.out.println("----------------------------");
			System.out.println("0.Back");
			System.out.println("99.Exit");

			number = in.nextInt();

		}
		return number;
	}

	private void showAllPacks() {
		displayPack(budgetPack1500, "Budget Pack 1500 Rs");
		displayPack(budgetPack2500, "Budget Pack 2500 Rs");
		displayPack(budgetPack7500, "Budget Pack 7500 Rs");

	}

	private void showPack(String pack) {
		if (pack.equalsIgnoreCase("Budget Pack 1500 Rs")) {
			displayPack(budgetPack1500, pack);
		} else if (pack.equalsIgnoreCase("Budget Pack 2500 Rs")) {
			displayPack(budgetPack2500, pack);
		} else if (pack.equalsIgnoreCase("Budget Pack 7500 Rs")) {
			displayPack(budgetPack7500, pack);
		} else {

		}

	}

	@Override
	public void addItem(String id, String name, double price, String pack) {
		if (pack.equalsIgnoreCase("Budget Pack 1500 Rs")) {
			budgetPack1500.add(new Product(id, name, price));
			System.out.println("Successfully added");
		} else if (pack.equalsIgnoreCase("Budget Pack 2500 Rs")) {
			budgetPack2500.add(new Product(id, name, price));
			System.out.println("Successfully added");
		} else if (pack.equalsIgnoreCase("Budget Pack 7500 Rs")) {
			budgetPack7500.add(new Product(id, name, price));
			System.out.println("Successfully added");
		} else {
			System.out.println("Invalid Pack");
			System.out.println("Adding Fail");
		}

	}

	@Override
	public void selectPacks() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1.Budget Pack 1500 Rs");
		System.out.println("2.Budget Pack 2500 Rs");
		System.out.println("3.Budget Pack 7500 Rs");
		System.out.println("Select your pack number : ");
		String menu = scan.nextLine();

		if (menu.equals("1")) {
			this.displayPack(budgetPack1500, "1.Budget Pack 1500 Rs");
		} else if (menu.equals("2")) {
			this.displayPack(budgetPack2500, "1.Budget Pack 2500 Rs");
		} else if (menu.equals("3")) {
			this.displayPack(budgetPack7500, "1.Budget Pack 7500 Rs");
		} else {
			System.out.println("Invalid pack number");
			this.selectPacks();
		}

	}

	@Override
	public void displayPack(ArrayList<Product> pack, String type) {
		int i = 1;
		int input;
		ArrayList<Product> selected = new ArrayList<>();
		System.out.println("\n\n\n######__" + type + "__######");
		System.out.println("--------Products List---------");
		for (Product p : pack) {
			System.out.println(i + ".  " + p.getId() + " : " + p.getName() + " : " + p.getPrice());
			++i;
		}

	}

	@Override
	public boolean removeProduct(String id, String pack) {
		boolean status = false;
		if (pack.equalsIgnoreCase("Budget Pack 1500 Rs")) {
			for (Product p : budgetPack1500) {
				if (p.getId().equals(id)) {
					budgetPack1500.remove(p);
					return true;
				}
			}

		} else if (pack.equalsIgnoreCase("Budget Pack 2500 Rs")) {
			for (Product p : budgetPack2500) {
				if (p.getId().equals(id)) {
					budgetPack2500.remove(p);
					return true;
				}
			}

		} else if (pack.equalsIgnoreCase("Budget Pack 7500 Rs")) {
			for (Product p : budgetPack7500) {
				if (p.getId().equals(id)) {
					budgetPack7500.remove(p);
					return true;
				}
			}

		} else {
			System.out.println("Invalid pack");
		}

		return false;
	}

	@Override
	public boolean updateProduct(String id, String productName, double price, String pack) {
		if (pack.equalsIgnoreCase("Budget Pack 1500 Rs")) {
			for (Product p : budgetPack1500) {
				if (p.getId().equals(id)) {
					p.setPrice(price);
					p.setName(productName);
					return true;
				}
			}

		} else if (pack.equalsIgnoreCase("Budget Pack 2500 Rs")) {
			for (Product p : budgetPack2500) {
				if (p.getId().equals(id)) {
					p.setPrice(price);
					p.setName(productName);
					return true;
				}
			}
		} else if (pack.equalsIgnoreCase("Budget Pack 7500 Rs")) {
			for (Product p : budgetPack7500) {
				if (p.getId().equals(id)) {
					p.setPrice(price);
					p.setName(productName);
					return true;
				}
			}

		} else {
			System.out.println("Invalid pack");
		}
		return false;
	}

	@Override
	public boolean checkID(String id, String pack) {

		if (id.trim().equals("")) {
			return false;
		}
		if (pack.equalsIgnoreCase("Budget Pack 1500 Rs")) {
			for (Product p : budgetPack1500) {
				if (p.getId().equals(id)) {
					return false;
				}
			}

		} else if (pack.equalsIgnoreCase("Budget Pack 2500 Rs")) {
			for (Product p : budgetPack2500) {
				if (p.getId().equals(id)) {
					return false;
				}
			}
		} else if (pack.equalsIgnoreCase("Budget Pack 7500 Rs")) {
			for (Product p : budgetPack7500) {
				if (p.getId().equals(id)) {
					return false;
				}
			}

		} else {
			System.out.println("Invalid pack");
		}
		return true;
	}

}
