package com.MediciManage.MediVersionOne;

public class Medicine {
	private String MedicineID;
	private String MedicineType;
	private int MedicineQuantity;
	private double MedicineUnitPrice;
	private String MedicineDescription;
	
	
	
	public Medicine() {
		super();
		
	}

	
	public Medicine(String medicineID, String medicineType, int medicineQuantity, double medicineUnitPrice,
			String medicineDescription) {
		super();
		MedicineID = medicineID;
		MedicineType = medicineType;
		MedicineQuantity = medicineQuantity;
		MedicineUnitPrice = medicineUnitPrice;
		MedicineDescription = medicineDescription;
	}

	public String getMedicineID() {
		return MedicineID;
	}

	public void setMedicineID(String medicineID) {
		MedicineID = medicineID;
	}

	public String getMedicineType() {
		return MedicineType;
	}

	public void setMedicineType(String medicineType) {
		MedicineType = medicineType;
	}

	public int getMedicineQuantity() {
		return MedicineQuantity;
	}

	public void setMedicineQuantity(int medicineQuantity) {
		MedicineQuantity = medicineQuantity;
	}

	public double getMedicineUnitPrice() {
		return MedicineUnitPrice;
	}

	public void setMedicineUnitPrice(double medicineUnitPrice) {
		MedicineUnitPrice = medicineUnitPrice;
	}

	public String getMedicineDescription() {
		return MedicineDescription;
	}

	public void setMedicineDescription(String medicineDescription) {
		MedicineDescription = medicineDescription;
	}
	
	
	

}
