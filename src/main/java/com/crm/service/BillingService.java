package com.crm.service;

import com.crm.core.billing.BillingInterface;
import com.crm.core.billing.BillingServiceProvider;
import com.crm.core.billing.Order;
import com.crm.core.billing.types.BillingType;
import com.google.inject.Inject;

public class BillingService {

	private final BillingInterface billing;
	
	@Inject
	private BillingService(BillingInterface billing)
	{
		System.out.println("Injected");
		this.billing = billing;
	}
	
	public void purchaseOrder(Order order)
	{
		System.out.println(billing);
	}
	
	public void cancelOrder(String orderId)
	{
		
	}

}

