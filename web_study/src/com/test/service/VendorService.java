package com.test.service;

import java.util.List;

import com.test.dto.Page;
import com.test.dto.Vendor;

public interface VendorService {
	List<Vendor> selectVendorsList(String viName, Page page);
	int insertVendor(String viName,String viDesc,String viAddress,String viPhone);
	int updateVendor(int viNum, String viName,String viDesc,String viAddress,String viPhone);
	int deleteVendor(int viNum);
	Vendor viewVendor(int viNum);
	int getTotalCount();
}
