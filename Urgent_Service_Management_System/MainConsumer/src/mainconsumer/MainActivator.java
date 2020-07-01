package mainconsumer;

import com.MediciManage.MediVersionOne.IMedicineManager;
import com.MediciManage.MediVersionOne.MedicineManagerIMPL;

import customermanage.ICustomerManage;
import deliverymanage.IDeliveryManage;
import essentialProductsManage.IEssentialProductManagement;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class MainActivator implements BundleActivator {

	ServiceReference<?> medicineRef;
	ServiceReference<?> essentialProductsRef;
	ServiceReference<?> deliveryServiceReference;
	ServiceReference<?> customerServiceReference;


	public void start(BundleContext context) throws Exception {
		System.out.println("Main Consumer started !!!");
		
		medicineRef = context.getServiceReference(IMedicineManager.class.getName());
		IMedicineManager IMedicMan = (MedicineManagerIMPL) context.getService(medicineRef);
		
		essentialProductsRef = context.getServiceReference(IEssentialProductManagement.class.getName());
		IEssentialProductManagement iEssentialProducts = (IEssentialProductManagement) context.getService(essentialProductsRef);
		
		deliveryServiceReference = context.getServiceReference(IDeliveryManage.class.getName());
		IDeliveryManage iDeliveryManage=(IDeliveryManage) context.getService(deliveryServiceReference);
		
		customerServiceReference = context.getServiceReference(ICustomerManage.class.getName());
		ICustomerManage icustomerManage=(ICustomerManage) context.getService(customerServiceReference);
		
		ImainConsumer consumer=new mainConsumerIMPL(IMedicMan,iEssentialProducts,iDeliveryManage,icustomerManage);
		consumer.OperateSystem();
		stop(context);
		
		
		
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Main Consummer stopped---!!!");
		context.ungetService(medicineRef);
		context.ungetService(essentialProductsRef);
		context.ungetService(deliveryServiceReference);
		context.ungetService(customerServiceReference);
		
		
	}

}
