package com.MediciManage.MediVersionOne;

import java.util.ArrayList;

public interface IMedicineManager {
	public void addMedicine();
	public void DisplayGivenMedicineById( );
	public ArrayList<Medicine> ListMedicineList();
	public void DeleteMedicine();
	public void IncreaseMedicineQuantity();
	public void DecreasemedicineQuantity();
	public void DisplayMedicineList();

}