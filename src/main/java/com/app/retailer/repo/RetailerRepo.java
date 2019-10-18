package com.app.retailer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.retailer.entity.RetailerEntity;

public interface RetailerRepo extends JpaRepository<RetailerEntity, Long>{

}
