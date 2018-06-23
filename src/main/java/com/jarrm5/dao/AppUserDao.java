package com.jarrm5.dao;

import java.util.List;
import java.util.Iterator;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.HibernateException; 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.transaction.jta.platform.internal.TransactionManagerBasedSynchronizationStrategy;
import com.jarrm5.listener.HibernateListener;
import com.jarrm5.model.AppUser;

public class AppUserDao {
	
	private SessionFactory sessionFactory;
	
	public AppUserDao() {
		try {
			/*sessionFactory = new Configuration()
		               .configure("hibernate.cfg.xml")
		               .addAnnotatedClass(AppUser.class)
		               .buildSessionFactory();*/
			sessionFactory = (SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
	
	/* Method to  READ all the Users to the system */
	@SuppressWarnings("unchecked")
	public void listAppUsers(){
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			List<AppUser> appUsers = session.createQuery("FROM AppUser").list(); 
			for (Iterator<AppUser> iterator = appUsers.iterator(); iterator.hasNext();){
				AppUser appUser = (AppUser) iterator.next(); 
				System.out.print("User id: " + appUser.getUserId()); 
				System.out.print("Username: " + appUser.getUsername());
				System.out.print("Password: " + appUser.getPassword());
			}
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction!=null) transaction.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}
	
	public boolean authenticateAppUser(AppUser appUser) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		AppUser retrievedUser = null;
		
		try {
			transaction = session.beginTransaction();
			retrievedUser = (AppUser)session.createQuery("FROM AppUser WHERE username = :username AND password = :password")
					.setParameter("username", appUser.getUsername())
					.setParameter("password", appUser.getPassword())
					.uniqueResult();
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction!=null) 
				transaction.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		
		if(retrievedUser != null) 
			return true;
		
		return false;
	}
	
}
