package com.test.service;

import com.test.service.implement.VendorServiceImpl;

public class ServiceFactory {
	
	private static VendorService vendorService = new VendorServiceImpl();
	
	public static VendorService getVendorService(){
		System.out.println(vendorService);
		return vendorService;
	}

}
