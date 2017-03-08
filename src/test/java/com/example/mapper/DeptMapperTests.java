package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptMapperTests {
	
	@Autowired
	DeptMapper mapper;
	
	@Test
	public void test00_confirmMapper() {
		System.out.println("Mapper = " + mapper);
	}
	@Test
	public void test00_selectTotal() {
		System.out.println("totalDept = " + mapper.selectTotalCount());
	}
	
	@Test
	public void test01_selectAll() {
		
		List<Dept> list = mapper.selectAll();
		
		for (Dept d : list) {
			System.out.println(d);
		}
	}
	@Test
	public void test01_selectAllWithEmp() {
		
		List<Dept> list = mapper.selectAllWithEmp();
		
		for (Dept d : list) {
			System.out.println(d);
		}
	}
	
	@Test
	public void test02_selectDeptPage() {
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<Dept> list = mapper.selectDeptPage(paging);
		
		for(Dept d : list) {
			System.out.println(d);
		}
	}
	@Test
	public void test02_selectDeptPageWithEmp() {
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<Dept> list = mapper.selectDeptPageWithEmp(paging);
		
		for(Dept d : list) {
			System.out.println(d);
		}
	}
	
	@Test
	public void test03_selectByDeptno() {
		Dept dept = mapper.selectByDeptno(10);
		if (dept == null) {
			throw new NotFoundRuntimeException("dept 정보가 없습니다.");
		}
		System.out.println(dept);
	}
	@Test
	public void test02_selectByDeptnoWithEmp() {
		Dept dept = mapper.selectByDeptnoWithEmp(40);
		if (dept == null) {
			throw new NotFoundRuntimeException("dept 정보가 없습니다.");
		}
		System.out.println(dept);
	}

}
