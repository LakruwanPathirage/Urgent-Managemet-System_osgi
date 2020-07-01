package com.MediManage.MediHelper;

public class MedicineHelperIMPL implements IMedicineHelper {

	@Override
	public boolean Availability(int qnty, String Type) {
		if (Type.equals("A"))
		{
			if (qnty < 250) 
				return true;
			else
				return false;	
				
		}
		else if (Type.equals("B"))
		{
			if (qnty < 350) 
				return true;
			else
				return false;
		}

		else if (Type.equals("C"))
		{
			if (qnty < 350) 
				return true;
			else
				return false;
		}
		else if (Type.equals("D"))
		{
			if (qnty < 350) 
				return true;
			else
				return false;
		}
		else
			return false;

	}


//	@Override
//	public double Total_Calculation(int qnty, double unitprice) {
//
//		
//		return (qnty * unitprice);
//	}

}
