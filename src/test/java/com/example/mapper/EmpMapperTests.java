package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Emp;

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
	
}
