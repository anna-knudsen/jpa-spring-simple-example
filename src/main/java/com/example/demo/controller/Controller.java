package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpa.CustomerEntity;
import com.example.demo.jpa.CustomerRepository;

@RestController
@RequestMapping("customers")
public class Controller {

	private final CustomerRepository repository;

	public Controller(CustomerRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public Iterable<CustomerEntity> getCustomers() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public CustomerEntity getCustomer(@PathVariable int id) {
		return repository.findCustomerById(id);
	}
}