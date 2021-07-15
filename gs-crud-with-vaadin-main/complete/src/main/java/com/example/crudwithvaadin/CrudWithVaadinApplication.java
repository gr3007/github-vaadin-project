package com.example.crudwithvaadin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudWithVaadinApplication {

	private static final Logger log = LoggerFactory.getLogger(CrudWithVaadinApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CrudWithVaadinApplication.class);
	}

	@Bean
	public CommandLineRunner loadData(CustomerRepository repository) {
		return (args) -> {
			String excelPath = "E:/IntelliJ/New folder/gs-crud-with-vaadin-main/complete/excel/my-excel.xlsx";
			String sheetName = "Sheet0";
			ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

			int row = excel.getRowCount();
			for (int i=1; i< row; i++){
				String fname = excel.getCellData(i,1);	
				String lname = excel.getCellData(i,3);
				String add = excel.getCellData(i,0);
				repository.save(new Customer(fname,lname,add));
			}
			// save a couple of customers
//			repository.save(new Customer("Jacky", "Bauer", "A"));
//			repository.save(new Customer("Chloe", "O'Brian", "B"));
//			repository.save(new Customer("Kim", "Bauer", "C"));
//			repository.save(new Customer("David", "Palmer", "D"));
//			repository.save(new Customer("Michelle", "Dessler", "E"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L).get();
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastNameStartsWithIgnoreCase('Bauer'):");
			log.info("--------------------------------------------");
			for (Customer bauer : repository
					.findByLastNameStartsWithIgnoreCase("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}

}
