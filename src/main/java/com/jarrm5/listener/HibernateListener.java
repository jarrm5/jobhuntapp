package com.jarrm5.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateListener implements ServletContextListener {
	
	private SessionFactory sessionFactory;
	public static final String KEY_NAME = HibernateListener.class.getName();

	public HibernateListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		try {
			/*URL url = HibernateListener.class.getResource("/hibernate.cfg.xml");
			configuration = new Configuration().configure(url);
			sessionFactory = configuration.buildSessionFactory();*/
			//sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(AppUser.class).buildSessionFactory();
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
			servletContextEvent.getServletContext().setAttribute(KEY_NAME, sessionFactory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
