package mainconsumer;

import java.util.ArrayList;
import java.util.Scanner;

import com.MediciManage.MediVersionOne.IMedicineManager;

import customermanage.Customer;
import customermanage.ICustomerManage;
import deliverymanage.Delivery;
import deliverymanage.IDeliveryManage;
import essentialProductsManage.IEssentialProductManagement;

public class mainConsumerIMPL implements ImainConsumer{

	IMedicineManager IMedicMan;
	IEssentialProductManagement iEssentialProducts;
	IDeliveryManage iDeliveryManage;
	ICustomerManage icustomerManage;
	
	
	ArrayList<Customer> customerList;
	ArrayList<Delivery> DeliveryList;
	
	public  mainConsumerIMPL(IMedicineManager IMedicMan,IEssentialProductManagement iEssentialProducts,IDeliveryManage iDeliveryManage,ICustomerManage icustomerManage) {
		
		this.IMedicMan=IMedicMan;
		this.iEssentialProducts=iEssentialProducts;
		this.iDeliveryManage=iDeliveryManage;
		this.icustomerManage=icustomerManage;
	}
	
	@Override
	public void OperateSystem(){

		Scanner in = new Scanner(System.in);
		System.out.println("...........---------Urgent Service Management System-------------................");
		decisionBoard();
		int input = in.nextInt();
		while (input != 5) {

			switch (input) {
			case 1:
				 urgentmedicine();
				break;
			case 2:
				 essentialProductMange();
				break;
			case 3:	customerManageMenu();
			    break;
			case 4: deliveryManageMenu();	    
			    break;
			default:
				System.out.println("Invalid input!!!");
				break;
			}
			decisionBoard();
			input = in.nextInt();
		}

	}

	private void decisionBoard() {
		System.out.println("");
		System.out.println("Select What do you need to manage:");
		System.out.println("  1 - Urgent-Medicine Management");
		System.out.println("  2 - Essential Products Management");
		System.out.println("  3 - Customer Service Management");
		System.out.println("  4 - Delivery Service Management");
		System.out.println("  5 - Exit");
		System.out.println("");
		System.out.print("Please enter valid number : ");
		System.out.println("");
	}

	@Override
	public void urgentmedicine() {
		Scanner in = new Scanner(System.in);
		addmedicinedashboard(); 
		int input = in.nextInt();

		while (input != 7) {

			switch (input) {
			case 1:
				IMedicMan.addMedicine();
				break;
			case 2:
				IMedicMan.DisplayMedicineList();
				break;
			case 3:
				IMedicMan. DisplayGivenMedicineById();
				break;		
			case 4:
				IMedicMan.IncreaseMedicineQuantity();
				break;
			case 5:
				IMedicMan. DecreasemedicineQuantity();
				break;
			case 6:
				IMedicMan.DeleteMedicine();
				break;
			default:
				System.out.println("No valid Number!!");
				break;
			}
			System.out.print("----------------------------------------------------------");
			addmedicinedashboard(); 
			input = in.nextInt();
		}
	}
	
	public  void addmedicinedashboard() {
		System.out.println("");
		System.out.println("       ----------Urgent Medicine Management------------");
		System.out.println("");
		System.out.println("    Select one of the  Below List");
		System.out.println("");
		System.out.println("      1 - Add  a urgent medicine");
		System.out.println("      2 - List  All medicines ");
		System.out.println("      3 - Show  specific medicine item details ");
		System.out.println("      4 - Increase medicine quantity ");
		System.out.println("      5 - Decrease medicine quantity");
		System.out.println("      6 - Delete Existing Urgent medicine");
		System.out.println("      7 - Back");
		System.out.println("");
		System.out.println("");
		System.out.print("Please enter a number : ");
	}
	public  int essentialProductMange() {

		int number = iEssentialProducts.selectOptions();

		return number;
	}
	//Delivery Management
			public int deliveryManageMenu() {

				int number = 0;
				while (number != 99) {

					System.out.println("****  Delivery Manage Menu   **** ");
					System.out.println("1.Assign New Delivery For Customer");
					System.out.println("2.Show All Assigned Deliveries With Customers");
					System.out.println("0.Back");
					System.out.println("99.Exit");

					Scanner in = new Scanner(System.in);
					number = in.nextInt();

					if (number == 0) {
						return number;
					}

					switch (number) {
					case 1:

						System.out.println("----------- Delivery Areas -----------------");

						iDeliveryManage.viewArea();

						System.out.println("----------- Enter Details -----------------");

						System.out.println("Enter Delivery Area: ");
						int typeArea = in.nextInt();
						String idnull = in.nextLine();

						String type = null;

						if (typeArea == 1) {
							type = "Colombo";
						} else if (typeArea == 2) {
							type = "Gampaha";
						} else if (typeArea == 3) {
							type = "Kalutara";
						} else if (typeArea == 4) {
							type = "Negambo";
						} else if (typeArea == 5) {
							type = "Kandy";
						} else if (typeArea == 6) {
							type = "Kurunegala";
						} else {
							break;
						}

						System.out.println("Enter the Vehicle No: ");
						String vehicleNo = in.nextLine();

						System.out.println("Enter Driver's Name: ");
						String driverName = in.nextLine();

						System.out.println("Enter customer ID: ");
						String customerId = in.nextLine();

						double price = iDeliveryManage.calculateDeliveryPrice(type);

						iDeliveryManage.assignNewDelivery(vehicleNo, driverName, customerId, type, price);
					
						deliveryShowAll();

						break;

					case 2:

						deliveryShowAll();

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

				} // while end

				return number;

			}
			
			public void deliveryShowAll() {

				DeliveryList = iDeliveryManage.getAssignedDeliveryList();

				int i = 0;

				for (Delivery delivery : DeliveryList) {

					i++;

					System.out.println("----------  Assigned Deliveries " + i + " -------");

					System.out.println("Area : " + delivery.getArea());
					System.out.println("Vehicle No : " + delivery.getVehicleNo());
					System.out.println("Driver's Name : " + delivery.getDriverName());
					System.out.println("Customer ID: " + delivery.getCustomerId());
					System.out.println("Total Price: " + delivery.getPrice());
				}

			}
			// End Delivery Management
			public int customerManageMenu() { 

				int number = 0;
				while (number != 99) {

					System.out.println("****  Customer Manage Menu   **** ");
					System.out.println("1.Add New Customer");
					System.out.println("2.Show All Customers");
					System.out.println("0.Back");
					System.out.println("99.Exit");

					Scanner in = new Scanner(System.in);
					number = in.nextInt();

					if (number == 0) {
						return number;
					}

			
						switch (number) {
						case 1:

							System.out.println("----------- Select Customer Type -----------------");

							icustomerManage.viewCustomerType();

							System.out.println("----------- Enter Details -----------------");

							System.out.println("Enter the Customer Type number: ");
							int customerType = in.nextInt();
							String idnull = in.nextLine();

							String custype = null;

							if (customerType == 1) {
								custype = "Elders who receive Pensions";
							} else if (customerType == 2) {
								custype = "Other Customers";
							} else {
								break;
							}

							System.out.println("Enter customer ID: ");
							String id = in.nextLine();

							System.out.println("Enter customer Name: ");
							String name = in.nextLine();

							System.out.println("Enter customer phone No: ");
							String phone = in.nextLine();
							
							System.out.println("Enter customer address: ");
							String address = in.nextLine();

							icustomerManage.assignNewCustomer(custype, id, name, phone, address);

							customerShowAll();

							break;

						case 2:

							customerShowAll();

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
			
			public void customerShowAll() {

				customerList = icustomerManage.newCustomerList();

				int i = 0;

				for (Customer customer : customerList) {
					i++;

					System.out.println("----------  Customer " + i + " -------");

					System.out.println("Type : " + customer.getType());
					System.out.println("ID     : " + customer.getId());
					System.out.println("Name   : " + customer.getName());
					System.out.println("Phone  : " + customer.getPhone());
					System.out.println("Address: " + customer.getAddress());
				}
			} 

	

}
