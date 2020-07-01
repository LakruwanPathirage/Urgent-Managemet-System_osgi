package deliverymanage;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {
	
	ServiceRegistration deliveryServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		

		System.out.println("Delivery Service Started...");
		
		IDeliveryManage iDeliveryManage=new DeliveryManageImpl();
		
		
		deliveryServiceRegistration = context.registerService(IDeliveryManage.class.getName(), iDeliveryManage, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Delivery Service Finished...");
		
		deliveryServiceRegistration.unregister();
	}

}
