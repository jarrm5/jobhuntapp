package com.jarrm5.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.finder.Test;

import javax.persistence.AssociationOverride;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.jarrm5.dao.AppUserDao;
import com.jarrm5.model.AppUser;

public class LoginAction extends ActionSupport implements ModelDriven<AppUser>,ServletContextAware{
	
	private AppUser appUser = new AppUser();
	private ServletContext servletContext;
	private AppUserDao appUserDao = new AppUserDao();
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public AppUser getAppUser() {
		return appUser;
	}
	
	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	
	public String execute() {  
		
		if(appUserDao.authenticateAppUser(appUser)) {
			
			return SUCCESS; 
		}
		
		addFieldError("username", "Authentication Failed.");
		
		return ERROR;
	}
	
	public void validate() {
		
		if(StringUtils.isEmpty(appUser.getUsername())) {
			addFieldError("username", "Please provide a username");
		}	
		if(StringUtils.isEmpty(appUser.getPassword())) {
			addFieldError("password", "Please provide a password");
		}	
	}
	
	@Override
	public AppUser getModel() {
		return appUser;
	}
}
