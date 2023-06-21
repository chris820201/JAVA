package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")  //public class Employee {
public class Employee implements Serializable{
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;   //員工編號
    private String name ;   //員工姓名
    private String gender ;   //性別
    private String birthday ;   //生日
    private String position ;   //職位
    private String account ;   //登錄名
    private String password ;   //密碼
    private String address ;   //地址
    private String phoneNo ;   //電話
    private String HireDate ;   //到職日
    private String ResignDate ;   //離職日
    private int Status ;   //狀態
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getHireDate() {
		return HireDate;
	}
	public void setHireDate(String hireDate) {
		HireDate = hireDate;
	}
	public String getResignDate() {
		return ResignDate;
	}
	public void setResignDate(String resignDate) {
		ResignDate = resignDate;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
    
   
    
    
}
