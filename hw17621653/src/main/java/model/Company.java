package model;

import java.io.Serializable;

public class Company implements Serializable {

	private String companyName;
	private Address location;
	private String companytype;

	public Company() {
		this.companyName=null;
		this.location=null;
		this.companytype=null;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}

	public String getCompanytype() {
		return companytype;
	}

	public void setCompanytype(String companytype) {
		this.companytype = companytype;
	}
	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", location=" + location + ", companytype=" + companytype + "]";
	}


}
