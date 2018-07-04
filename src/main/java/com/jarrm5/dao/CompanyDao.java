package com.jarrm5.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.identity.SybaseAnywhereIdentityColumnSupport;

import com.jarrm5.listener.HibernateListener;
import com.jarrm5.model.AppUser;
import com.jarrm5.model.Company;

public class CompanyDao {
	
	private SessionFactory sessionFactory;
	
	public CompanyDao() {
		try {     
			//sessionFactory = (SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
	
	public void listCompanies() {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			List<Company> companies = session.createQuery("FROM Company").list(); 
			for (Iterator<Company> iterator = companies.iterator(); iterator.hasNext();){
				Company company = (Company) iterator.next(); 
				System.out.println("Company id: " + company.getCompanyId()); 
				System.out.println("Company name: " + company.getCompanyName());
				System.out.println("Website: " + company.getWebsite());
				System.out.println("Street: " + company.getStreet());
				System.out.println("City: " + company.getCity());
				System.out.println("State: " + company.getState());
				System.out.println("ZIP: " + company.getZip());
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

}
