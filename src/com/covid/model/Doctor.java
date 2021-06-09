package com.covid.model;

public class Doctor {
	private Integer dr_id;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String gender;
	private Integer age;
	private String address;
	private String blood_group;
	private Integer sc_id;

	@Override
	public String toString() {
		return "Doctor [dr_id=" + dr_id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", email="
				+ email + ", gender=" + gender + ", age=" + age + ", address=" + address + ", blood_group="
				+ blood_group + ", sc_id=" + sc_id + "]";
	}

	public Integer getDr_id() {
		return dr_id;
	}

	public void setDr_id(Integer dr_id) {
		this.dr_id = dr_id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	public Integer getSc_id() {
		return sc_id;
	}

	public void setSc_id(Integer sc_id) {
		this.sc_id = sc_id;
	}
}
