package com.crm.service;

import com.crm.core.billing.BillingInterface;
import com.crm.core.billing.BillingServiceProvider;
import com.crm.core.billing.Order;
import com.crm.core.billing.types.BillingType;
import com.google.inject.Inject;

public class BillingService {

	private BillingServiceProvider provider;
	
	@Inject
	private BillingService(BillingServiceProvider provider, String type)
	{
		System.out.println("Injected");
		System.out.println(type);
		this.provider = provider;
		System.out.println(provider);
	}
	
	public void purchaseOrder(Order order, BillingType billingType)
	{
		BillingInterface billing = provider.getBillingService(billingType);
		System.out.println(billing);
	}
	
	public void cancelOrder(String orderId, BillingType billingType)
	{
		
	}

}

