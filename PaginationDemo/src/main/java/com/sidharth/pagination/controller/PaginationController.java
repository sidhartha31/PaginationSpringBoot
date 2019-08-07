package com.sidharth.pagination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sidharth.pagination.entity.DatatableEntity;
import com.sidharth.pagination.service.PaginationService;

@RestController
@RequestMapping("/data")
public class PaginationController {

	@Autowired
	private PaginationService service;
	
	@GetMapping("/all/{page}/{size}/{sortBy}")
	public ResponseEntity<List<DatatableEntity>> getAllData(@PathVariable("page") Integer page, @PathVariable("size") Integer size,
			@PathVariable("sortBy") String sortBy) {
		
		List<DatatableEntity> dataList = service.getPaginatedData(page, size,sortBy);
		return new ResponseEntity<List<DatatableEntity>>(dataList, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/all/{page}/{size}")
	public ResponseEntity<List<DatatableEntity>> getAllDataWithoutSort(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		
		List<DatatableEntity> dataList = service.getPaginatedDataWithoutSort(page, size);
		for(DatatableEntity d : dataList) {
			System.out.println(d.getId()+" "+d.getName()+" "+d.getCompany());
		}
		return new ResponseEntity<List<DatatableEntity>>(dataList, new HttpHeaders(), HttpStatus.OK);
	}
}
