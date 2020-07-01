package essentialProductsManage;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * The activator class controls the plug-in life cycle
 */
public class ProductManagementServiceActivator implements BundleActivator {

	ServiceRegistration essentialProductService;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Essential Products Service Started...");

		IEssentialProductManagement iessentialProductManager = new EssentialProductManagementImpl();

		essentialProductService = context.registerService(IEssentialProductManagement.class.getName(),
				iessentialProductManager, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Essential Products Service Finished...");

		essentialProductService.unregister();
	}

}