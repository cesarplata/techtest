package com.napptilus.techtest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.napptilus.techtest.entity.PrecioEntity;

public interface PrecioRepository extends CrudRepository<PrecioEntity, Integer> {

	@Query(value = "SELECT p FROM PrecioEntity p "
			+ "where p.productId = ?1 and p.brandId = ?2 "
			+ "and p.startDate <= ?3 and p.endDate >= ?3"
			+ "ORDER BY p.priority DESC")
	List<PrecioEntity> findFinalPrice(Integer productId, Integer brandId, Date appDate);
}