package com.sidharth.pagination.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sidharth.pagination.entity.DatatableEntity;

@Repository
public interface PaginationRepository extends PagingAndSortingRepository<DatatableEntity, Integer> {

}
