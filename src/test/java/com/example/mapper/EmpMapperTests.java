package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Emp;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpMapperTests {
	
	@Autowired
	EmpMapper mapper;
	
	@Test
	public void test00_confirm() {
		System.out.println("mapper = " + mapper);
	}
	@Test
	public void test00_selectTotalCount() {
		System.out.println("totalEmp = " + mapper.selectTotalCount());
	}
	@Test
	public void test01_selectAll() {
		
		List<Emp> list = mapper.selectAll();
		
		for (Emp e : list) {
			System.out.println(e);
			
		}
	}
	@Test
	public void test01_selectAllWithDept() {
		List<Emp> list = mapper.selectAllWithDept();
		
		for (Emp e : list) {
			System.out.println(e);
		}
	}
	
	@Test
	public void test02_selectEmpPage() {
		Pagination paging =  new Pagination();
		paging.setTotalItem(mapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<Emp> list = mapper.selectEmpPage(paging);
		
		for (Emp e : list) {
			System.out.println(e);
		}
	}
	@Test
	public void test02_selectEmpPageWithDept() {
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<Emp> list = mapper.selectEmpPageWithDept(paging);
		
		for (Emp e : list)
			System.out.println(e);
	}
	
	@Test
	public void test03_selectByEmpno() {
		Emp emp = mapper.selectByEmpno(7934);
		
		if (emp == null) {
			throw new NotFoundRuntimeException("Emp 정보가 없습니다.");
		}
		System.out.println(emp);
	}
	@Test
	public void test03_selectByEmpnoWithDept() {
		Emp emp = mapper.selectByEmpnoWithDept(7934);
		
		if (emp == null) {
			throw new NotFoundRuntimeException("Emp 정보가 없습니다.");
		}
		System.out.println(emp);
	}
	
}
