package com.covid.model;

public class Patient {
	private Integer pt_id;
	private Integer uid;
	private String name;
	private String phone;
	private String email;
	private String gender;
	private Integer age;
	private String address;
	private String blood_group;
	private String disease;
	private String result;
	private Integer dr_id;
	private Integer sc_id;
	public Integer getPt_id() {
		return pt_id;
	}
	public void setPt_id(Integer pt_id) {
		this.pt_id = pt_id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
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
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Integer getDr_id() {
		return dr_id;
	}
	public void setDr_id(Integer dr_id) {
		this.dr_id = dr_id;
	}
	public Integer getSc_id() {
		return sc_id;
	}
	public void setSc_id(Integer sc_id) {
		this.sc_id = sc_id;
	}
	@Override
	public String toString() {
		return "Patient [pt_id=" + pt_id + ", uid=" + uid + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", gender=" + gender + ", age=" + age + ", address=" + address + ", blood_group=" + blood_group
				+ ", disease=" + disease + ", result=" + result + ", dr_id=" + dr_id + ", sc_id=" + sc_id + "]";
	}

	

}
