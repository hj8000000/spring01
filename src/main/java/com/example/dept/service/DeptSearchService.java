package com.example.dept.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Dept;
import com.example.mapper.DeptMapper;
import com.example.util.Pagination;

@Service
public class DeptSearchService {
	
	@Autowired
	DeptMapper mapper;
	
	public List<Dept> getListAll() {
		return getListAll(false);
	}
	
	public List<Dept> getListAll(boolean withEmp) {
		List<Dept> list = null;
		if (withEmp)
			list = mapper.selectAllWithEmp();
		else
			list = mapper.selectAll();
		
		return list;
	}
	
	public Map<String, Object> getPage(int pageNo) {
		return getPage(pageNo, false);
	}
	public Map<String, Object> getPage(int pageNo, boolean withEmp) {
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectTotalCount());
		paging.setPageNo(pageNo);
		
		List<Dept> list = null;
		if (withEmp)
			list = mapper.selectDeptPageWithEmp(paging);
		else
			list = mapper.selectDeptPage(paging);

		Map<String, Object> map = new HashMap<>();
		map.put("depts", list);
		map.put("paging", paging);
		
		return map;
	}
	
	public Dept getDeptByDeptno(int deptno) {
		return getDeptByDeptno(deptno, false);
	}
	public Dept getDeptByDeptno(int deptno, boolean withEmp) {
		Dept dept = null;
		if (withEmp)
			dept = mapper.selectByDeptnoWithEmp(deptno);
		else
			dept = mapper.selectByDeptno(deptno);
		
		return dept;
	}
}
