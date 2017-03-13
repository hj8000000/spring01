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
		
		System.out.println(dept);
	}
	@Test
	public void test03_selectByDeptnoWithEmp() {
		Dept dept = mapper.selectByDeptnoWithEmp(40);
		
		System.out.println(dept);
	}
	
	@Test
	public void test04_insert() {
		Dept dept =  new Dept();
		dept.setDeptno(50);
		dept.setDname("jsp");
		
		Dept d = mapper.selectByDeptno(dept.getDeptno());
		
		if (d != null) {
			System.out.println("error = Deptno 가 존재합니다");
			return;
		}
		
		int cnt = mapper.insert(dept);
		System.out.println(mapper.selectByDeptno(dept.getDeptno()));	
	}
	
	@Test
	public void test06_deleteByDeptno() {
		int deptno = 50;
		int cnt = mapper.deleteByDeptno(deptno);
		System.out.println("cnt = " + cnt);
		System.out.println("dept = " + mapper.selectByDeptno(deptno));
	}
}
