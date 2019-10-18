package com.app.retailer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_RETAILERS1")
public class RetailerTableEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "email")
	private String email;

	public RetailerTableEntity() {
		super();
	}

	public RetailerTableEntity(String name, String state, String country, String pincode, String mobile, String email) {
		super();
		this.name = name;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.mobile = mobile;
		this.email = email;
	}

	public RetailerTableEntity(Long id, String name, String state, String country, String pincode, String mobile,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.mobile = mobile;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "RetailerTableEntity [id=" + id + ", name=" + name + ", state=" + state + ", country=" + country
				+ ", pincode=" + pincode + ", mobile=" + mobile + ", email=" + email + "]";
	}

}
