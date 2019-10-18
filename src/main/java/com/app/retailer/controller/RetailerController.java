package com.app.retailer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.retailer.entity.RetailerEntity;
import com.app.retailer.entity.RetailerTableEntity;
import com.app.retailer.repo.RetailerTableRepo;
import com.app.retailer.service.RetailerService;
import com.app.retailer.service.RetailerTableService;

@RestController
@CrossOrigin

public class RetailerController {

	@Autowired
	RetailerService service;
	@Autowired
	RetailerTableService tableService;
	@Autowired
	RetailerTableRepo tableRepo;

	@GetMapping("/retailers")
	public ResponseEntity<List<RetailerEntity>> getAllRetailers() {
		List<RetailerEntity> list = service.getAllRetailers();

		return new ResponseEntity<List<RetailerEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/retailersTable")
	public ResponseEntity<List<RetailerTableEntity>> getAllRetailersTable() {
		List<RetailerTableEntity> list = tableService.getAllRetailers();

		return new ResponseEntity<List<RetailerTableEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/getRetailer/{id}")
	public ResponseEntity<RetailerEntity> getRetailerById(@PathVariable("id") Long id) {
		RetailerEntity entity = service.getRetailerById(id);

		return new ResponseEntity<RetailerEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<RetailerEntity> createOrUpdateRetailer(RetailerEntity Retailer) {
		RetailerEntity updated = service.createOrUpdateRetailer(Retailer);
		return new ResponseEntity<RetailerEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/deleteRetailer/{id}")
	public HttpStatus deleteRetailerById(@PathVariable("id") Long id) {
		service.deleteRetailerById(id);
		return HttpStatus.FORBIDDEN;
	}

	@GetMapping("/addToTable/{id}")
	public ResponseEntity<List<RetailerTableEntity>> addToTable(@PathVariable("id") Long id) {
		RetailerEntity entity = service.getRetailerById(id);
		tableService.createOrUpdateRetailer(entity);
		List<RetailerTableEntity> list = tableService.getAllRetailers();
		return new ResponseEntity<List<RetailerTableEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/allDetails")
	public ResponseEntity<List<RetailerTableEntity>> allDetails() {
		List<RetailerTableEntity> list = tableService.getAllRetailers();
		return new ResponseEntity<List<RetailerTableEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/paginate")
	public ResponseEntity<Page<RetailerTableEntity>> paginate(Pageable pageable) {
		Page<RetailerTableEntity> table;
		table = tableRepo.findAll(pageable);
		return new ResponseEntity<Page<RetailerTableEntity>>(table, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/sortByNameAsc")
	public ResponseEntity<Page<RetailerTableEntity>> sortByNameAsc(Pageable pageable) {
		Page<RetailerTableEntity> table = tableRepo.findByOrderByNameAsc(pageable);
		return new ResponseEntity<Page<RetailerTableEntity>>(table, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/sortByAddressAsc")
	public ResponseEntity<Page<RetailerTableEntity>> sortByAddressAsc(Pageable pageable) {
		Page<RetailerTableEntity> table = tableRepo.findByOrderByStateAsc(pageable);
		return new ResponseEntity<Page<RetailerTableEntity>>(table, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/sortByEmailAsc")
	public ResponseEntity<Page<RetailerTableEntity>> sortByEmailAsc(Pageable pageable) {
		Page<RetailerTableEntity> table = tableRepo.findByOrderByEmailAsc(pageable);
		return new ResponseEntity<Page<RetailerTableEntity>>(table, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/sortByMobileAsc")
	public ResponseEntity<Page<RetailerTableEntity>> sortByMobileAsc(Pageable pageable) {
		Page<RetailerTableEntity> table = tableRepo.findByOrderByMobileAsc(pageable);
		return new ResponseEntity<Page<RetailerTableEntity>>(table, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/sortByNameDesc")
	public ResponseEntity<Page<RetailerTableEntity>> sortByNameDesc(Pageable pageable) {
		Page<RetailerTableEntity> table = tableRepo.findByOrderByNameDesc(pageable);
		return new ResponseEntity<Page<RetailerTableEntity>>(table, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/sortByAddressDesc")
	public ResponseEntity<Page<RetailerTableEntity>> sortByAddressDesc(Pageable pageable) {
		Page<RetailerTableEntity> table = tableRepo.findByOrderByStateDesc(pageable);
		return new ResponseEntity<Page<RetailerTableEntity>>(table, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/sortByEmailDesc")
	public ResponseEntity<Page<RetailerTableEntity>> sortByEmailDesc(Pageable pageable) {
		Page<RetailerTableEntity> table = tableRepo.findByOrderByEmailDesc(pageable);
		return new ResponseEntity<Page<RetailerTableEntity>>(table, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/sortByMobileDesc")
	public ResponseEntity<Page<RetailerTableEntity>> sortByMobileDesc(Pageable pageable) {
		Page<RetailerTableEntity> table = tableRepo.findByOrderByMobileDesc(pageable);
		return new ResponseEntity<Page<RetailerTableEntity>>(table, new HttpHeaders(), HttpStatus.OK);
	}

}
