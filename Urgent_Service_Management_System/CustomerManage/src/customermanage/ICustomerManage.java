package customermanage;

import java.util.ArrayList;

public interface ICustomerManage {
	
	public ArrayList<Customer> newCustomerList();
	public void viewCustomerType();
	public void assignNewCustomer(String type,String id, String name, String phone , String address);

}
