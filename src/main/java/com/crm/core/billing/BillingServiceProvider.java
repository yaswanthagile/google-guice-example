package com.crm.core.billing;
import com.crm.core.billing.impl.PaypalImpl;
import com.crm.core.billing.impl.StripeImpl;
import com.crm.core.billing.types.BillingType;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;


public class BillingServiceProvider implements Provider<BillingInterface>
{
	private final Provider<StripeImpl> stripeImpl;
	private final Provider<PaypalImpl> paypalImpl;
	private final BillingType billingType;
	
	
	@Inject
	public BillingServiceProvider(Provider<StripeImpl> stripeImpl, Provider<PaypalImpl> paypalImpl, BillingType billingType) {
		// TODO Auto-generated constructor stub
		this.stripeImpl = stripeImpl;
		this.paypalImpl = paypalImpl;
		this.billingType = billingType;
	}
	
	public BillingInterface get() {
		BillingInterface billingImpl = null;
		switch(billingType)
		{
			case STRIPE :  billingImpl = stripeImpl.get();
			break;
			case PAYPAL : billingImpl = paypalImpl.get();
			break;
		}
		
		return billingImpl;
	}
}