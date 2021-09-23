package com.model;

public class Restaurant {
	String name;
	String otime;
	String ctime;
	String phone;
	String addr;
	String cuisine;
	int status;
	
	



	public Restaurant() {
		
	}
	
	
	
	public Restaurant(String name, String otime, String ctime, String phone,String addr,String cuisine,int status) {
		super();
		this.name = name;
		this.otime = otime;
		this.ctime = ctime;
		this.phone = phone;
		this.addr=addr;
		this.cuisine=cuisine;
		this.status=status;
		
	}
	
	
	public Restaurant(String name) {
		super();
		this.name = name;
	}



	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOtime() {
		return otime;
	}
	public void setOtime(String otime) {
		this.otime = otime;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}

}
