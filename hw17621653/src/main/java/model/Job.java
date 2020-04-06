package model;

import java.io.Serializable;

public class Job implements Serializable{
	private Company company;
	private String position;


	public Job() {
		// TODO Auto-generated constructor stub
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	@Override
	public String toString() {
		return "Job [company=" + company + ", position=" + position + "]";
	}
	
	

}
