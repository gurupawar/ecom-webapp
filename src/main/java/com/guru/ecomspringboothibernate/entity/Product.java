package com.guru.ecomspringboothibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "p_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String p_id;

	@Column(name = "p_name")
	private String p_name;
	@Column(name = "p_quenty")
	private String p_quenty;
	@Column(name = "p_price")
	private String p_price;
	@Column(name = "p_photo")
	private String p_photo;
	@Column(name = "p_desc")
	private String p_desc;
	@ManyToOne
	private Category category;

	public Product(String p_id, String p_name, String p_quenty, String p_price, String p_photo, String p_desc,
			Category category) {
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_quenty = p_quenty;
		this.p_price = p_price;
		this.p_photo = p_photo;
		this.p_desc = p_desc;
		this.category = category;
	}

	public Product() {
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_quenty() {
		return p_quenty;
	}

	public void setP_quenty(String p_quenty) {
		this.p_quenty = p_quenty;
	}

	public String getP_price() {
		return p_price;
	}

	public void setP_price(String p_price) {
		this.p_price = p_price;
	}

	public String getP_photo() {
		return p_photo;
	}

	public void setP_photo(String img) {
		this.p_photo = img;
	}

	public String getP_desc() {
		return p_desc;
	}

	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}

	@Override
	public String toString() {
		return "Product [P_desc=" + p_desc + ", category=" + category + ", p_id=" + p_id + ", p_name=" + p_name
				+ ", p_photo=" + p_photo + ", p_price=" + p_price + ", p_quenty=" + p_quenty + "]";
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category id) {
		this.category = id;
	}

}
