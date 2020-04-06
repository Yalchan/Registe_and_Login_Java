package model.beans;

import java.io.Serializable;
import java.util.List;

import model.Address;
import model.Job;
import model.UserSkill;

public class User implements Serializable, Comparable<User> {
	
	private int id;
	private String firstName;
	private String secondName;
	private String familyName;
	private Job job;
	private String description;
	private String email;
	private String password;
	private String phoneNumber;
	private Address address;
	private boolean isMale;
	private List<UserSkill> skills;

	public User() {
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

	public boolean isMale() {
		return isMale;
	}


	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}


	public List<UserSkill> getSkills() {
		return skills;
	}

	public void setSkills(List<UserSkill> skills) {
		this.skills = skills;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (this.compareTo(other)==0)
			return true;
		else
			return false;
		}


	@Override
	public int compareTo(User o) {
		return this.email.compareTo(o.getEmail());
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", familyName="
				+ familyName + ", job=" + job + ", description=" + description + ", email=" + email + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", address=" + address + ", skills=" + skills + "]";
	}

}
