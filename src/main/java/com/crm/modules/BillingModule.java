package com.crm.modules;

import com.crm.core.billing.BillingInterface;
import com.crm.core.billing.BillingServiceProvider;
import com.crm.core.billing.gateway.annotations.Stripe;
import com.crm.core.billing.impl.StripeImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

public class BillingModule extends AbstractModule {
	
	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		// bind(BillingInterface.class).to(BillingImpl.class);//.in(Singleton.class);
	//	bind(BillingInterface.class).annotatedWith(Stripe.class).to(StripeImpl.class);//.in(Singleton.class);
		
		bind(BillingInterface.class).toProvider(BillingServiceProvider.class);
	}
	
	/*@Provides
	BillingInterface getBillingInterface()
	{
		if(billingImpl != null )
			return billingImpl;
		
		return billingImpl = new BillingImpl();
	}*/

}
