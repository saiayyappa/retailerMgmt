package com.app.retailer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.retailer.entity.RetailerEntity;
import com.app.retailer.repo.RetailerRepo;

@Service
public class RetailerService {

	@Autowired
	RetailerRepo repository;

	public List<RetailerEntity> getAllRetailers() {
		List<RetailerEntity> RetailerList = repository.findAll();

		if (RetailerList.size() > 0) {
			return RetailerList;
		} else {
			return new ArrayList<RetailerEntity>();
		}
	}

	public RetailerEntity getRetailerById(Long id) {
		Optional<RetailerEntity> retailer = repository.findById(id);
		return retailer.get();
	}

	public RetailerEntity createOrUpdateRetailer(RetailerEntity entity) {
		entity = repository.save(entity);
		return entity;
	}

	public void deleteRetailerById(Long id) {
		repository.deleteById(id);

	}
}
