package deliverymanage;

import java.util.ArrayList;

public class DeliveryManageImpl implements IDeliveryManage {

	ArrayList<Delivery> assignedDeliveryList=new ArrayList<Delivery>();

	@Override
	public void viewArea() {

		System.out.println("1.Colombo");
		System.out.println("2.Gampaha");
		System.out.println("3.Kalutara");
		System.out.println("4.Negambo");
		System.out.println("5.Kandy");
		System.out.println("6.Kurunegala");

	}


	public void assignNewDelivery(String vehicleNo, String driverName, String customerId, String area, double price) {

		Delivery delivery = new Delivery(vehicleNo, driverName, customerId, area, price);
		assignedDeliveryList.add(delivery);

	}

	@Override
	public ArrayList<Delivery> getAssignedDeliveryList() {

		return this.assignedDeliveryList;
	}
	
	@Override
	public double calculateDeliveryPrice(String area) {

		double amount=0;

		if (area == "Colombo") {
			amount = 100;

		}

		else if (area == "Gampaha") {
			amount = 150;

		}

		else if (area == "Kalutara") {
			amount = 200;

		}

		else if (area == "Negambo") {
			amount = 300;

		}
		else if (area == "Kandy") {
			amount = 250;

		}
		else if (area == "Kurunegala") {
			amount = 300;

		}

		return amount;

	}


	




	
}
