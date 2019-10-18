package com.app.retailer.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.retailer.entity.RetailerTableEntity;

public interface RetailerTableRepo extends PagingAndSortingRepository<RetailerTableEntity, Long> {

	Page<RetailerTableEntity> findByOrderByNameAsc(Pageable pageable);

	Page<RetailerTableEntity> findByOrderByStateAsc(Pageable pageable);

	Page<RetailerTableEntity> findByOrderByEmailAsc(Pageable pageable);

	Page<RetailerTableEntity> findByOrderByMobileAsc(Pageable pageable);

	Page<RetailerTableEntity> findByOrderByNameDesc(Pageable pageable);

	Page<RetailerTableEntity> findByOrderByStateDesc(Pageable pageable);

	Page<RetailerTableEntity> findByOrderByEmailDesc(Pageable pageable);

	Page<RetailerTableEntity> findByOrderByMobileDesc(Pageable pageable);
}
