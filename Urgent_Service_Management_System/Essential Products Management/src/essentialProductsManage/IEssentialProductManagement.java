package essentialProductsManage;

import java.util.ArrayList;


public interface IEssentialProductManagement{
	
	public int selectOptions();
	
	public void addItem(String id,String name,double price,String pack);
	
	public boolean checkID(String id , String pack);
	
	public void selectPacks();
		
	public void displayPack(ArrayList<Product> pack, String type);
	
	public boolean removeProduct(String productName, String pack);
	
	public boolean updateProduct(String id,String productName,double price,String pack);
}
