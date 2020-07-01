package deliverymanage;

import java.util.ArrayList;

public interface IDeliveryManage {
	
	public void assignNewDelivery(String vehicleNo, String driverName, String customerId, String area, double price);
	public void viewArea();
	public ArrayList<Delivery> getAssignedDeliveryList();
	
	public double calculateDeliveryPrice(String area);

}
