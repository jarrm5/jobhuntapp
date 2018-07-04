package com.jarrm5.dao;

import java.util.Iterator;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.validation.constraints.Null;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jarrm5.model.Company;
import com.jarrm5.model.JobListing;

public class JobListingDao {

	private SessionFactory sessionFactory;
	
	public JobListingDao() {
		try {     
			//sessionFactory = (SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
	
	@SuppressWarnings("unchecked")
	public void listJobListings() {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			List<Object> jobListings = session.createQuery("FROM JobListing job LEFT OUTER JOIN job.company").list();
			for (Iterator<Object> iterator = jobListings.iterator(); iterator.hasNext();){
				Object[] tuple = (Object[])iterator.next();
				JobListing jobListing = (JobListing)tuple[0];
				System.out.println("Listing id: " + jobListing.getJobListingId()); 
				System.out.println("Position Title: " + jobListing.getPositionTitle());
				System.out.println("Listing Description: " + handleNull(jobListing.getDescription()));
				System.out.println("Application Link: " + handleNull(jobListing.getListingLink()));
				System.out.println("Date: " + handleNull(jobListing.getDateApplied().toString()));
				if(jobListing.getCompany() != null) {
					System.out.println("Company Name: " + handleNull(jobListing.getCompany().getCompanyName()));
					System.out.println("Company Website: " + handleNull(jobListing.getCompany().getWebsite()));
				}
				else {
					System.out.println("No company provided for this listing");
				}
				System.out.println();
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction!=null) 
				transaction.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
	}
	public String handleNull(String field) {
		return field == null || field.equals("") ? "N/A" : field; 
	}
}
