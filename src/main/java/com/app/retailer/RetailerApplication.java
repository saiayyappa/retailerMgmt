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
		service.createOrUpdateRetailer(new RetailerEntity("Rasheed", "Surat", "India", "123456", "1234567890", "rasheed1@gmail.com"));
		service.createOrUpdateRetailer(new RetailerEntity("Ganesh", "Chennai", "India", "234567", "9876543210", "ganesh678@gmail.com"));
		service.createOrUpdateRetailer(new RetailerEntity("Sarah", "Chandigarh", "India", "345678", "9988776655", "sarah7@gmail.com"));
		service.createOrUpdateRetailer(new RetailerEntity("Baskar", "Baroda", "India", "456789", "1122334455", "baskar123@gmail.com"));
		service.createOrUpdateRetailer(new RetailerEntity("Tejas", "Vadodara", "India", "567890", "2233445566", "tejastejas@gmail.com"));
		service.createOrUpdateRetailer(new RetailerEntity("Hameedha", "Mumbai", "India", "123234", "9922334455", "hameedha96@gmail.com"));
		service.createOrUpdateRetailer(new RetailerEntity("Dipanjan", "Delhi", "India", "234345", "8977665544", "dipan7jan@gmail.com"));
		service.createOrUpdateRetailer(new RetailerEntity("Fareeda", "Mysore", "India", "456567", "8766554430", "fareeda45@gmail.com"));
		service.createOrUpdateRetailer(new RetailerEntity("Ramesh", "Bangalore", "India", "678789", "9988774433", "ramesh12@gmail.com"));
		service.createOrUpdateRetailer(new RetailerEntity("Ang", "Assam", "India", "890987", "9944556677", "angbender@gmail.com"));
		
		logger.info("All retailers -> {}", service.getAllRetailers());
	}
}
