package com.app.retailer;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.retailer.entity.RetailerEntity;
import com.app.retailer.service.RetailerService;

@SpringBootApplication
public class RetailerApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	RetailerService service;

	public static void main(String[] args) {
		SpringApplication.run(RetailerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.createOrUpdateRetailer(new RetailerEntity("Dummy1", "Iowa", "US", "987352", "9876543210", "dummy1@gmail.com"));
		service.createOrUpdateRetailer(new RetailerEntity("Dummy2", "Ohio", "US", "654321", "9876543210", "dummy2@gmail.com"));
		service.createOrUpdateRetailer(new RetailerEntity("Dummy3", "Wisconsin", "US", "987456", "9876543210", "dummy3@gmail.com"));
		service.createOrUpdateRetailer(new RetailerEntity("Dummy4", "Texas", "US", "657513", "9876543210", "dummy4@gmail.com"));
		service.createOrUpdateRetailer(new RetailerEntity("Dummy5", "Missouri", "US", "325733", "9876543210", "dummy5@gmail.com"));
		logger.info("All retailers -> {}", service.getAllRetailers());
	}
}
