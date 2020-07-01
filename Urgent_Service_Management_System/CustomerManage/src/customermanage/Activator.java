package customermanage;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration customerServiceRegistration;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Customer Service Started...");

		ICustomerManage icustomerManage = new CustomerManageImpl();

		customerServiceRegistration = context.registerService(ICustomerManage.class.getName(), icustomerManage, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Customer Service Finished...");

		customerServiceRegistration.unregister();
	}

}
