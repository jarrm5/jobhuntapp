package com.jarrm5.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;

import java.util.Map;
import javax.servlet.ServletContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.HttpParametersAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import com.jarrm5.dao.AppUserDao;
import com.jarrm5.model.AppUser;

public class LoginAction extends ActionSupport implements ModelDriven<AppUser>,ServletContextAware,SessionAware,HttpParametersAware{
	
	private final static long serialVersionUID = 1L; 
	
	private AppUser appUser = new AppUser();
	private ServletContext servletContext;
	private SessionMap<String,Object> session;
	private AppUserDao appUserDao = new AppUserDao();
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap)session;
	}
	
	@Override
	public void setParameters(HttpParameters parameters) {
		
	}

	public AppUser getAppUser() {
		return appUser;
	}
	
	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	
	public String execute() {  
		
		if(appUserDao.authenticateAppUser(appUser)) {
			session.put("currentUser", appUser);
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
