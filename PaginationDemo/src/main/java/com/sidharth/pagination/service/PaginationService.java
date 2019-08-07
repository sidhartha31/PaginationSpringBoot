package com.sidharth.pagination.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sidharth.pagination.entity.DatatableEntity;
import com.sidharth.pagination.repository.PaginationRepository;

@Service
public class PaginationService {

	@Autowired
	private PaginationRepository repository;

	public List<DatatableEntity> getPaginatedData(Integer page, Integer size, String sortBy) {

		Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));
		Page<DatatableEntity> dataList = repository.findAll(paging);

		if(dataList.hasContent()) {
			return dataList.getContent();
		}
		return new ArrayList<DatatableEntity>();
	}

	public List<DatatableEntity> getPaginatedDataWithoutSort(Integer page, Integer size) {

		Pageable paging = PageRequest.of(page, size);
		Page<DatatableEntity> dataList = repository.findAll(paging);

		if(dataList.hasContent()) {
			return dataList.getContent();
		}
		return new ArrayList<DatatableEntity>();
	}
}
