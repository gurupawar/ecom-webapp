package com.guru.ecomspringboothibernate.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@Column(name = "c_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String c_id;

	@Column(name = "c_name")
	private String c_name;

	@Column(name="c_desc")
	private String c_desc;

	@OneToMany
	private List<Product> products = new ArrayList<>();

	public Category(String c_id, String c_name, String c_desc, List<Product> products) {
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_desc = c_desc;
		this.products = products;
	}

	public Category(String c_name, String c_desc, List<Product> products) {
		this.c_name = c_name;
		this.c_desc = c_desc;
		this.products = products;
	}


	public Category() {
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_desc() {
		return c_desc;
	}

	public void setC_desc(String c_desc) {
		this.c_desc = c_desc;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [c_desc=" + c_desc + ", c_id=" + c_id + ", c_name=" + c_name + ", products=" + products + "]";
	}

}
