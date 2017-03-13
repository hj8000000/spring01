package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;
import com.example.domain.Emp;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpMapperTests {
	
	@Autowired
	EmpMapper empMapper;
	
	@Autowired
	DeptMapper deptMapper;
	
	@Test
	public void test00_confirm() {
		System.out.println("mapper = " + empMapper);
	}
	@Test
	public void test00_selectTotalCount() {
		System.out.println("totalEmp = " + empMapper.selectTotalCount());
	}
	@Test
	public void test01_selectAll() {
		
		List<Emp> list = empMapper.selectAll();
		
		for (Emp e : list) {
			System.out.println(e);
			
		}
	}
	@Test
	public void test01_selectAllWithDept() {
		List<Emp> list = empMapper.selectAllWithDept();
		
		for (Emp e : list) {
			System.out.println(e);
		}
	}
	
	@Test
	public void test02_selectEmpPage() {
		Pagination paging =  new Pagination();
		paging.setTotalItem(empMapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<Emp> list = empMapper.selectEmpPage(paging);
		
		for (Emp e : list) {
			System.out.println(e);
		}
	}
	@Test
	public void test02_selectEmpPageWithDept() {
		Pagination paging = new Pagination();
		paging.setTotalItem(empMapper.selectTotalCount());
		paging.setPageNo(1);
		
		List<Emp> list = empMapper.selectEmpPageWithDept(paging);
		
		for (Emp e : list)
			System.out.println(e);
	}
	
	@Test
	public void test03_selectByEmpno() {
		Emp emp = empMapper.selectByEmpno(7934);
		
//		if (emp == null) {
//			throw new NotFoundRuntimeException("Emp 정보가 없습니다.");
//		}
		System.out.println(emp);
	}
	@Test
	public void test03_selectByEmpnoWithDept() {
		Emp emp = empMapper.selectByEmpnoWithDept(7934);
		
		if (emp == null) {
			throw new NotFoundRuntimeException("Emp 정보가 없습니다.");
		}
		System.out.println(emp);
	}
	
	@Test
	public void test04_insert() {
		Emp emp = new Emp();
		emp.setEname("xxx");
		emp.setDeptno(40);
		
		Dept dept = deptMapper.selectByDeptno(emp.getDeptno());
		
		if (emp == null) {
			System.out.println("error = Deptno 가 없습니다.");
			return;
		}
		
		int cnt = empMapper.insert(emp);
		System.out.println(empMapper.selectByEmpno(emp.getEmpno()));
	}
	
}
