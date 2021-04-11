package com.example.demo.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "customers")
public class CustomerEntity {

	@Column(name = "customer_name")
	private String name;
	@Id
	@Column(name = "customer_id")
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}