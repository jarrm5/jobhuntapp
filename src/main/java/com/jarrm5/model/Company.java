package com.jarrm5.model;

import java.util.Set;

public class Company {
	
	private int companyId;
	private Set<JobListing> jobListings;
	private String companyName;
	private String website;
	private String street;
	private String city;
	private String state;
	private String zip;

	public Company() {
		// TODO Auto-generated constructor stub
	}
	
	public Company(int companyId, String companyName, String website, String street,
			String city, String state, String zip) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.website = website;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public Company(String companyName, String website, String street, String city, String state, String zip) {
		super();
		this.companyName = companyName;
		this.website = website;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public Set<JobListing> getJobListings() {
		return jobListings;
	}
	public void setJobListings(Set<JobListing> jobListings) {
		this.jobListings = jobListings;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
