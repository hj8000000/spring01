package com.example.util;

import org.junit.Test;

public class PaginationTests {
	
	@Test
	public void test01() {
		Pagination paging = new Pagination();
		
		paging.setTotalItem(4079);  	//select count(*) from city
		paging.setPageNo(50);			// 1 page
		
		System.out.println("itemsPerPage = " + paging.getItemsPerPage());
		System.out.println("totalPage = " + paging.getTotalPage());
		System.out.println("firstItem = " + paging.getFirstItem()); 	// (page당 10개라고하면) 1page 라면 1
		System.out.println("lastItem =  " + paging.getLastItem());		// 1page 라면 10
	}
	
	@Test
	public void test02() {
		Pagination paging = new Pagination();
		paging.setTotalItem(457);
		
		for (int i=1; i<=paging.getTotalPage(); i++) {
			paging.setPageNo(i);
			System.out.println("pagingNO = " + paging.getPageNo() +
								", firstItem = " + paging.getFirstItem() + 
								", lastItem = " + paging.getLastItem() +
								", offset = " + (paging.getFirstItem()-1) +
								", itemsPerPage = " + paging.getItemsPerPage()
								);
		}
	}
}
