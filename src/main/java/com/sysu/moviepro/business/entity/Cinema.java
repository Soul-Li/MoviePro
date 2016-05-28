package com.sysu.moviepro.business.entity;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cinema")
public class Cinema {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column
	private String description;
	
public Cinema() {}
	
	public Cinema(String name, String address, String description) {
		super();
		this.name = name;
		this.address = address;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Cinema [id=" + id + ", name=" + name + ", address=" + address + ", description=" + description + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
