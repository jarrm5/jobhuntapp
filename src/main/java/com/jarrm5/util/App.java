package com.jarrm5.util;

import com.jarrm5.dao.AppUserDao;
import com.jarrm5.dao.CompanyDao;
import com.jarrm5.dao.JobListingDao;
import com.jarrm5.model.AppUser;
import com.jarrm5.model.Company;

public class App {

	public static void main(String[] args) {
		
		/*AppUserDao appUserDao = new AppUserDao();
		AppUser appUser = new AppUser("jarrm5","password1");
		boolean result = appUserDao.authenticateAppUser(appUser);
		appUserDao.listAppUsers();*/
		
		CompanyDao companyDao = new CompanyDao();
		//companyDao.listCompanies();
		companyDao.listJobListingsByCompanyName(new Company(1,"","","","","",""));
		
		/*JobListingDao jobListingDao = new JobListingDao();
		jobListingDao.listJobListings();*/
		
		
		
	}

}
