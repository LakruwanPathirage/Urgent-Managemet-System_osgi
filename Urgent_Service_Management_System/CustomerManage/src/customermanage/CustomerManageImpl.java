package customermanage;

import java.util.ArrayList;

public class CustomerManageImpl implements ICustomerManage{

	ArrayList<Customer> customerList=new ArrayList<Customer>();	
	
	public void viewCustomerType() {

		System.out.println("1.Elders who receive Pensions");
		System.out.println("2.Other customers");

	}

	@Override
	public void assignNewCustomer(String type,String id, String name, String phone, String address) {
		Customer newCustomer = new Customer(type,id, name, phone , address);
		customerList.add(newCustomer);
		
	}
	
	@Override
	public ArrayList<Customer> newCustomerList() {		
		return customerList;
	}


	
}
