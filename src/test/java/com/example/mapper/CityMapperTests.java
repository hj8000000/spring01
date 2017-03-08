package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.City;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityMapperTests {
	
	@Autowired
	CityMapper citymapper;
	
	@Test
	public void test00_confirm() {
		System.out.println("mapper = " + citymapper);
	}
	
	@Test
	public void test00_selectTotalCount() {
		System.out.println("totalCity = " + citymapper.selectTotalCount());
	}
	
	@Test
	public void test01_selectAll() {
		List<City> list = citymapper.selectAll();
		
		for (City c : list)
			System.out.println(c);
	}
	@Test
	public void test01_selectAllWithCity() {
		List<City> list = citymapper.selectAllWithCountry();
		
		for (City c : list)
			System.out.println(c);
	}
	
	@Test
	public void test02_selectPage() {
		Pagination paging = new Pagination();
		paging.setTotalItem(citymapper.selectTotalCount());
		paging.setPageNo(407);
		
		List<City> list = citymapper.selectPage(paging);
		
		for (City c : list)
			System.out.println(c);
	}
	
	@Test
	public void test02_selectPageWithCountry() {
		Pagination paging = new Pagination();
		paging.setTotalItem(citymapper.selectTotalCount());
		paging.setPageNo(2);
		
		List<City> list = citymapper.selectPageWithCountry(paging);
		
		for (City c : list)
			System.out.println(c);
	}
	
	@Test
	public void test03_selectById() {
		City city = citymapper.selectById(1000000000);
		
		if (city == null) {
			throw new NotFoundRuntimeException("City 정보가 없습니다.");
		}
		System.out.println(city);
	}
	
	@Test
	public void test03_selectByIdWithCountry() {
		City city = citymapper.selectByIdWithCountry(1000000);
		
		if (city == null) {
			throw new NotFoundRuntimeException("City 정보가 없습니다.");
		}
		System.out.println(city);
	}
}
