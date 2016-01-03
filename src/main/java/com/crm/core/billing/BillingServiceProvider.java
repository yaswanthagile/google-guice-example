package com.crm.core.billing;
import com.crm.core.billing.impl.PaypalImpl;
import com.crm.core.billing.impl.StripeImpl;
import com.crm.core.billing.types.BillingType;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class BillingServiceProvider implements Provider<BillingInterface>
{
	private final Provider<StripeImpl> stripeImpl;
	private final Provider<PaypalImpl> paypalImpl;
	
	
	@Inject
	public BillingServiceProvider(Provider<StripeImpl> stripeImpl, Provider<PaypalImpl> paypalImpl) {
		// TODO Auto-generated constructor stub
		this.stripeImpl = stripeImpl;
		this.paypalImpl = paypalImpl;
	}
	
	public BillingInterface get() {
		// TODO Auto-generated method stub
		return stripeImpl.get();
	}
	
	public BillingInterface getBillingService(BillingType type)
	{
		BillingInterface billingImpl = null;
		switch(type)
		{
			case STRIPE :  billingImpl = stripeImpl.get();
			break;
			case PAYPAL : billingImpl = paypalImpl.get();
			break;
		}
		
		return billingImpl;
	}
	
}