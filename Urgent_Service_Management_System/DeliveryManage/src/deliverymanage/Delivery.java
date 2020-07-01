package deliverymanage;

public class Delivery {
	
	
	
	private String vehicleNo;
	private String driverName;
	private String customerId;
	private String area;
	private double price;
	public Delivery(String vehicleNo, String driverName, String customerId, String area, double price) {
		super();
		this.vehicleNo = vehicleNo;
		this.driverName = driverName;
		this.customerId = customerId;
		this.area = area;
		this.price = price;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

	




	
}
