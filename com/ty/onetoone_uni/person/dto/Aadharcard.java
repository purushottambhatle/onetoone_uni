package com.ty.onetoone_uni.person.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Aadharcard {
	@Id
	private int aid;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAaddress() {
		return aaddress;
	}
	public void setAaddress(String aaddress) {
		this.aaddress = aaddress;
	}
	private String aname;
	private String aaddress;

}
