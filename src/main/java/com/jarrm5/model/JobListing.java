package com.jarrm5.model;

import java.util.Date;

public class JobListing {
	
	private int jobListingId;
	private String positionTitle;
	private String description;
	private String listingLink;
	private Date dateApplied;
	private Company company;

	public JobListing() {}

	public JobListing(String positionTitle, String description, String listingLink, Date dateApplied, Company company) {
		super();
		this.positionTitle = positionTitle;
		this.description = description;
		this.listingLink = listingLink;
		this.dateApplied = dateApplied;
		this.company = company;
	}

	public int getJobListingId() {
		return jobListingId;
	}

	public void setJobListingId(int jobListingId) {
		this.jobListingId = jobListingId;
	}

	public String getPositionTitle() {
		return positionTitle;
	}

	public void setPositionTitle(String positionTitle) {
		this.positionTitle = positionTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getListingLink() {
		return listingLink;
	}

	public void setListingLink(String listingLink) {
		this.listingLink = listingLink;
	}

	public Date getDateApplied() {
		return dateApplied;
	}
	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
	}
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	

}
