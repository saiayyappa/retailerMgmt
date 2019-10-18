package com.app.retailer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.retailer.entity.RetailerEntity;
import com.app.retailer.entity.RetailerTableEntity;
import com.app.retailer.repo.RetailerTableRepo;

@Service
public class RetailerTableService {

	@Autowired
	RetailerTableRepo repository;

	public RetailerTableEntity createOrUpdateRetailer(RetailerEntity entity) {
		RetailerTableEntity r = new RetailerTableEntity();
		r.setName(entity.getName());
		r.setState(entity.getState());
		r.setCountry(entity.getCountry());
		r.setMobile(entity.getMobile());
		r.setPincode(entity.getPincode());
		r.setEmail(entity.getEmail());
		r = repository.save(r);
		return r;
	}

	public List<RetailerTableEntity> getAllRetailers() {
		List<RetailerTableEntity> RetailerList = (List<RetailerTableEntity>) repository.findAll();

		if (RetailerList.size() > 0) {
			return RetailerList;
		} else {
			return new ArrayList<RetailerTableEntity>();
		}
	}

	public Page<RetailerTableEntity> retailerList(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
