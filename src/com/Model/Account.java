package com.Model;

public class Account {

	int accno;
	String name;
	String address;
	String pan;
	String adhar;
	Double balence;
	
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
	
	public Double getBalence() {
		return balence;
	}
	public void setBalence(Double balence) {
		this.balence = balence;
	}
	@Override
	public String toString() {
		
		return "Account Details : "+"\nAccount Number : "+getAccno()+"\nAccount Holder Name : "+getName()+"\nAddress : "+getAddress()+
				"\nPan Number : "+getPan()+"\nAdhar Number : "+getAdhar()+"\nAccount Balence : "+getBalence();
	}
	
	
}
