package com.guru.ecomspringboothibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "u_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String u_id;

	@Column(name = "u_Fname")
	private String u_Fname;
	@Column(name = "u_Lname")
	private String u_Lname;
	@Column(name = "u_email")
	private String u_email;
	@Column(name = "u_pass")
	private String u_pass;

	public User() {
	}

	public User(String u_Fname, String u_Lname, String u_email, String u_pass) {
		this.u_Fname = u_Fname;
		this.u_Lname = u_Lname;
		this.u_email = u_email;
		this.u_pass = u_pass;
	}

	public User(String u_id, String u_Fname, String u_Lname, String u_email, String u_pass) {
		this.u_id = u_id;
		this.u_Fname = u_Fname;
		this.u_Lname = u_Lname;
		this.u_email = u_email;
		this.u_pass = u_pass;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_Fname() {
		return u_Fname;
	}

	public void setU_Fname(String u_Fname) {
		this.u_Fname = u_Fname;
	}

	public String getU_Lname() {
		return u_Lname;
	}

	public void setU_Lname(String u_Lname) {
		this.u_Lname = u_Lname;
	}

	public String getU_email() {
		return u_email;
	}

	public String getU_pass() {
		return u_pass;
	}

	public void setU_pass(String u_pass) {
		this.u_pass = u_pass;
	}

	public String toString() {
		return "User [u_Fname=" + u_Fname + ", u_Lname=" + u_Lname + ", u_email=" + u_email + ", u_id=" + u_id
				+ ", u_pass=" + u_pass + "]";
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

}
