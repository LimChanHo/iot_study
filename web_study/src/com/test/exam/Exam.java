package com.test.exam;

import com.test.dto.Goods;
import com.test.dto.Page;

public class Exam {
	
	public void chaingePage(Page page){
		page.setNowPage(2);
	}
	public static void main(String[] args){
		Page page = new Page();
		page.setNowPage(10);
		
		Goods goods = new Goods();
		goods.setPage(page);
		
		Page page2 = goods.getPage();
		page2 = new Page();
		System.out.println(goods.getPage().getNowPage());
		System.out.println(page2.getNowPage());
		
	}
}
;