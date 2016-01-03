package com.crm.core.billing.types;

import com.google.inject.Singleton;

@Singleton
public enum BillingType {
	STRIPE, PAYPAL;
	
	BillingType()
	{
		
	}
}
