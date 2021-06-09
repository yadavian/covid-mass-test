package com.covid.model;

public class HigherOfficials {
	private Integer ho_id;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String address;

	public Integer getHo_id() {
		return ho_id;
	}

	public void setHo_id(Integer ho_id) {
		this.ho_id = ho_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "HigherOfficials [ho_id=" + ho_id + ", password=" + password + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + "]";
	}
}
