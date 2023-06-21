package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "product")
public class Product {	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int pId;
	    private int fId;
	    private String pName;
	    private int price;
	    private int status;
	    private String descc;	    
	    private String remark;
	    private int sortId;
		public int getpId() {
			return pId;
		}
		public void setpId(int pId) {
			this.pId = pId;
		}		
		
		public int getfId() {
			return fId;
		}
		public void setfId(int fId) {
			this.fId = fId;
		}
		public String getpName() {
			return pName;
		}
		public void setpName(String pName) {
			this.pName = pName;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getDescc() {
			return descc;
		}
		public void setDesc(String descc) {
			this.descc = descc;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public int getSortId() {
			return sortId;
		}
		public void setSortId(int sortId) {
			this.sortId = sortId;
		}
}
