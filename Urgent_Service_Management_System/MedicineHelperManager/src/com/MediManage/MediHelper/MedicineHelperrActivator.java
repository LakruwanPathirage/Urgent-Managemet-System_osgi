package com.MediManage.MediHelper;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * The activator class controls the plug-in life cycle
 */
public class MedicineHelperrActivator implements BundleActivator {

	ServiceRegistration<?> serviceMediHelperRegistration;
	@Override
	public void start(BundleContext context)  {
		System.out.println("MedicineManage Helper Started----!!!");
		IMedicineHelper MediHelper=new MedicineHelperIMPL();
		serviceMediHelperRegistration= context.registerService(IMedicineHelper.class.getName(), MediHelper, null);
	}

	@Override
	public void stop(BundleContext context)  {
		System.out.println("MedicineManage Helper Stooped----!!!");
		serviceMediHelperRegistration.unregister();
	}

	

}
