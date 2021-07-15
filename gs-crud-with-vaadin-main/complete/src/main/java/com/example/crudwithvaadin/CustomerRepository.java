package com.example.crudwithvaadin;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Bean
	List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
}
