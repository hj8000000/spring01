package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.City;

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
}
