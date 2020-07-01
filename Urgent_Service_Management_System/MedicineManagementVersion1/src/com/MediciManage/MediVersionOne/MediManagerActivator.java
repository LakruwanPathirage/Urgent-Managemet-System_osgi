package com.MediciManage.MediVersionOne;

import com.MediManage.MediHelper.IMedicineHelper;
import com.MediManage.MediHelper.MedicineHelperIMPL;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;


/**
 * The activator class controls the plug-in life cycle
 */
public class MediManagerActivator implements BundleActivator {

	ServiceRegistration<?> medicine_publisher_Registartion;
	ServiceReference<?> medicinelperReference; 
	
	
	

	@Override
	public void start(BundleContext context) throws Exception {
		medicinelperReference =context.getServiceReference(IMedicineHelper.class.getName());
		IMedicineHelper imedicineHelper = (MedicineHelperIMPL) context.getService(medicinelperReference);
		
		System.out.println("MedicineManager Started----!!!");
		IMedicineManager manger = new MedicineManagerIMPL(imedicineHelper);
		medicine_publisher_Registartion = context.registerService(IMedicineManager.class.getName(), manger, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Medicine Publisher Stoped----!!!");
		medicine_publisher_Registartion.unregister();
		context.ungetService(medicinelperReference);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	
}
