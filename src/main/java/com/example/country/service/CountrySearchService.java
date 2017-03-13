package com.example.country.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;
import com.example.mapper.CountryMapper;
import com.example.util.Pagination;

@Service
public class CountrySearchService {
	
	@Autowired
	CountryMapper mapper;
	
	public List<Country> getListAll() {
		
		return getListAll(false);
		
	}
	public List<Country> getListAll(boolean withCity) {
		
		List<Country> list = null;
		
		if (withCity)
			list = mapper.selectAllWithCity();
		else
			list = mapper.selectAll();
		
		return list;
		
	}
	
	public Map<String, Object> getPage(int pageNo) {
		
		return getPage(pageNo, false);
		
	}
	public Map<String, Object> getPage(int pageNo, boolean withCity) {
	
		Pagination paging = new Pagination();
		paging.setTotalItem(mapper.selectTotalCount());
		paging.setPageNo(pageNo);
		
		List<Country> list = null;
		if (withCity)
			list = mapper.selectPageWithCity(paging);
		else
			list = mapper.selectPage(paging);
		
		Map<String, Object> map = new HashMap<>();
		map.put("countrys", list);
		map.put("paging", paging);
		
		return map;
		
	}
	
	public Country getCountryByCode(String code) {
		
		return getCountryByCode(code, false);
	
	}
	public Country getCountryByCode(String code,boolean withCity) {
		
		Country country = null;
		
		if (withCity)
			country = mapper.selectByCodeWithCity(code);
		else
			country = mapper.selectByCode(code);
		
		return country;
		
	}

}
