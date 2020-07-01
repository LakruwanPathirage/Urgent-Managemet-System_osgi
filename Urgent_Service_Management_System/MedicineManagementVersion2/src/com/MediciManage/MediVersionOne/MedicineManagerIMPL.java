package com.MediciManage.MediVersionOne;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import com.MediManage.MediHelper.IMedicineHelper;

public class MedicineManagerIMPL implements IMedicineManager {

	IMedicineHelper imedicineHelper = null;
	ArrayList<Medicine> List =new ArrayList<Medicine>();

	public MedicineManagerIMPL(IMedicineHelper imedicineHelper) {
		this.imedicineHelper = imedicineHelper;
	}

	@Override
	public ArrayList<Medicine> ListMedicineList() {

		

		Medicine medicineOne = new Medicine("MED01", "A", 25, 1200,"This medicine can be used for headache");
		Medicine medicineTwo = new Medicine("MED02", "B", 40, 1400,"Don't give this medicine without getting permission from doctor");
		Medicine medicineThree = new Medicine("MED03", "C", 50, 1400,"This medicine is not good for heart patients");
		Medicine medicineFour = new Medicine("MED04", "D", 60, 1600,"very powerful medicine,can be damage to brain");

		List.add(medicineOne);
		List.add(medicineTwo);
		List.add(medicineThree);
		List.add(medicineFour);

		return List;

	}

	@Override
	public void addMedicine() {

		Medicine medicine = new Medicine();
		Scanner scanner = new Scanner(System.in);
		System.out.println("");
		System.out.println("    ---Adding Medicine---");
		System.out.println("Enter Medicine id          : ");
		medicine.setMedicineID(scanner.nextLine());

		System.out.println("Select Medicine Name Listed below");

		System.out.println("  A - Medicine Type A");
		System.out.println("  B - Medicine Type B");
		System.out.println("  C - Medicine Type C");
		System.out.println("  D - Medicine Type D");
		System.out.println("");
		System.out.println("  :");
		String Type = scanner.nextLine().toUpperCase();
		medicine.setMedicineType(Type);

		boolean Isright = true;
		while (Isright) {
		System.out.println("Enter Medicine Quantity     : ");
			int quantity = scanner.nextInt();
			Isright = Quantitychecker(quantity, Type);
			if (Isright) {
				medicine.setMedicineQuantity(quantity);
				Isright = false;
			} else {
				System.out.println("Store is fully packed with medicine Type " + Type);
				Isright = true;
			}
		}

		System.out.println("Enter medicine unit price  : ");
		medicine.setMedicineUnitPrice(scanner.nextDouble());
		scanner.nextLine();
		
		System.out.println("Enter Medicine Description  : ");
		String descrip=scanner.nextLine();
		medicine.setMedicineDescription(descrip);
		
		
		
		
		List.add(medicine);
		System.out.println("Medicine added successfully----!!!");

	}

	@Override
	public void DisplayGivenMedicineById() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("");
		System.out.println("    ---Show  specific medicine item details---");
		System.out.print("Enter Medicine id             : ");

		String MedicineID = scanner.nextLine();

		for (Medicine medicine : ListMedicineList()) {
			if (medicine.getMedicineID().equals(MedicineID)) {
				System.out.println("MedicineType           : " + medicine.getMedicineType());
				System.out.println("MedicineQuantity       : " + medicine.getMedicineQuantity());
				System.out.println("MedicineUnitPrice      : " + medicine.getMedicineUnitPrice());
				System.out.println("Medicine Description   : " + medicine.getMedicineDescription());
				return;
			}
		}

		System.out.print("Can't find medicine details for given id ");

	}

	@Override
	public void DeleteMedicine() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("");
		System.out.println("    ---Delete Existing Urgent medicine---");
		System.out.print("Enter medicine id to delete: ");
		String Medicid = scanner.nextLine();

		for (Medicine medicine : ListMedicineList()) {
			if (medicine.getMedicineID().equals(Medicid)) {
				List.remove(medicine);
				System.out.print("Medicine removed succesfully ");
				return;
			}
		}

		System.out.print("Something goes wrong ");

	}

	@Override
	public void IncreaseMedicineQuantity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("");
		System.out.println("    ---Increase medicine quantity ---");
		System.out.print("Enter medicine id to increase medicine quantity: ");
		String Medicid = scanner.nextLine();
		boolean Isright = true;
		for (Medicine medicine : ListMedicineList()) {
			if (medicine.getMedicineID().equals(Medicid)) {
				
				while (Isright) {
					System.out.print("Enter Medicine Quantity    : ");
					int quantity = scanner.nextInt();
					Isright = Quantitychecker(quantity + medicine.getMedicineQuantity(), medicine.getMedicineType());
					if (Isright) {
						medicine.setMedicineQuantity(quantity + medicine.getMedicineQuantity());
						System.out.println("Incresed Medicine Quantity  Successfully   : ");
						Isright = false;
					} else {
						System.out.println("Store is fully packed with medicine Type  " + medicine.getMedicineType());
						Isright = true;
					}
				}
			}
		}

	}

	@Override
	public void DecreasemedicineQuantity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("");
		System.out.println("    ---Decrease medicine quantity ---");
		System.out.print("Enter medicine id to Descrease medicine quantity: ");
		String Medicid = scanner.nextLine();
		boolean Isright = true;
		for (Medicine medicine : ListMedicineList()) {
			if (medicine.getMedicineID().equals(Medicid)) {
				//
				while (Isright) {
					System.out.println("Enter Medicine Quantity    : ");
					int quantity = scanner.nextInt();
					int newqntity = (medicine.getMedicineQuantity() - quantity);
					if (newqntity > -1) {
						Isright = true;
					}else {
						Isright = false;
					}
					if (Isright) {
						medicine.setMedicineQuantity(newqntity);
						System.out.print("Descreased Medicine Quantity  Successfully!! ");
						Isright = false;
					} else {
						System.out.println("Can't Decreased more than original quantity quantity from Type  " + medicine.getMedicineType());
						Isright = true;
					}
				}
			}
		}

	}
	
	public void DisplayMedicineList() {
		System.out.println("");
		System.out.println("    ---List  All medicines ---");
		for (Medicine medicine : ListMedicineList()) 
			 {  System.out.println(".........");
			    System.out.println("    MedicineId                : " + medicine.getMedicineID());
				System.out.println("    MedicineType              : " + medicine.getMedicineType());
				System.out.println("    MedicineQuantity          : " + medicine.getMedicineQuantity());
				System.out.println("    MedicineUnitPrice         : " + medicine.getMedicineUnitPrice());
				System.out.println("    MedicineUnitDescription   : " + medicine.getMedicineDescription());
				System.out.println("...........");
			
			}
		
	}
	
	public boolean Quantitychecker(int qnty, String Type) {

		return imedicineHelper.Availability(qnty, Type);

	}

}
