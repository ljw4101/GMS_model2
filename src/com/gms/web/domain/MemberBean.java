package com.gms.web.domain;

import java.io.Serializable;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//DB에 저장되는 값만 정의해야 함
	private String id, pw, ssn, name, regdate, phone, email, major, subject, profile;
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getId(){
		return id;
	}
	public void setPw(String pw){
		this.pw = pw;
	}
	public String getPw(){
		return pw;
	}
	public void setSSN(String ssn){
		this.ssn = ssn;
	}
	public String getSSN(){
		return ssn;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setRegdate(String regdate){
		this.regdate = regdate;
	}
	public String getRegdate(){
		return regdate;
	}

	public String toString(){
		return String.format("%s %s %s %s %s\n", id, pw, name, ssn, regdate);
		//return "Welcome "+id;
	}
	
}
