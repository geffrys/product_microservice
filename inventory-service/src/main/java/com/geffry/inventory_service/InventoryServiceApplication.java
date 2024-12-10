package com.geffry.inventory_service;

import com.geffry.inventory_service.model.Inventory;
import com.geffry.inventory_service.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	// TODO: Delete this line, cause it is for a testing purposes, this line loads an examples, but then it doesn't
	//  be required, then we'll add an communication between ms to control this inventory. Or batch proceses to
	//  update it.
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory i1 = new Inventory();
			i1.setSkuCode("iphone_15");
			i1.setQuantity(100);
			Inventory i2 = new Inventory();
			i2.setQuantity(2);
			i2.setSkuCode("iphone_15_pro");
			inventoryRepository.save(i1);
			inventoryRepository.save(i2);
		};
	}
}
