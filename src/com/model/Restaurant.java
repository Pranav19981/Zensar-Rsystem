package com.model;

public class Restaurant {
	String name;
	int otime;
	int ctime;
	int phone;
	String addr;
	String cuisine;
	
	public Restaurant() {
		
	}
	
	
	
	public Restaurant(String name, int otime, int ctime, int phone,String addr,String cuisine) {
		super();
		this.name = name;
		this.otime = otime;
		this.ctime = ctime;
		this.phone = phone;
		this.addr=addr;
		this.cuisine=cuisine;
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
	public int getOtime() {
		return otime;
	}
	public void setOtime(int otime) {
		this.otime = otime;
	}
	public int getCtime() {
		return ctime;
	}
	public void setCtime(int ctime) {
		this.ctime = ctime;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	

}
