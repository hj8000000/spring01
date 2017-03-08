package com.example.emp.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Emp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpSearchServiceTests {

	@Autowired
	EmpSearchService service;
	
	@Test
	public void test00_confirmService() {
		System.out.println("service = " + service);
	}
	
	@Test
	public void test01_getListAll() {
		List<Emp> list = service.getListAll();
		for (Emp e : list)
			System.out.println(e);
	}
	@Test
	public void test01_getListAll_withDept() {
		List<Emp> list = service.getListAll(true);
		for (Emp e : list)
			System.out.println(e);
	}
	
	@Test
	public void test02_getPage() {
		Map<String, Object> map = service.getPage(1);
		
		List<Emp> list = (List<Emp>)map.get("emps");
		for (Emp e : list)
			System.out.println(e);
		System.out.println(map.get("paging"));
	}
	@Test
	public void test02_getPage_WithDept() {
		Map<String, Object> map = service.getPage(1, true);
		
		List<Emp> list = (List<Emp>)map.get("emps");
		for (Emp e : list)
			System.out.println(e);
		System.out.println(map.get("paging"));
	}
	
	@Test
	public void test03_getEmpByEmpno() {
		Emp emp = service.getEmpByEmpno(7934);
		System.out.println(emp);
	}
	@Test
	public void test03_getEmpByEmpno_WithDept() {
		Emp emp = service.getEmpByEmpno(7934, true);
		System.out.println(emp);
	}
}
