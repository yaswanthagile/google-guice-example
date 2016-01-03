import com.crm.core.billing.types.BillingType;
import com.crm.modules.BillingModule;
import com.crm.service.BillingService;
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class GuiceMain {
	
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new BillingModule(){
			@Override
			protected void configure() {
				// TODO Auto-generated method stub
				super.configure();
				bind(BillingType.class).toInstance(BillingType.STRIPE);
			}
		});
	
		BillingService service = injector.getInstance(BillingService.class);
			//System.out.println(service);
			service.purchaseOrder(null);
	}
}
