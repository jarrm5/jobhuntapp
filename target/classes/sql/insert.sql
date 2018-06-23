INSERT INTO app_user (username,password) VALUES ('jarrm5','password1');

INSERT INTO location (street,city,state,zip) VALUES 
	('10990 Roe Ave','Overland Park','KS','66211'),
	('11730 Plaza America Dr #205','Reston','VA','20190'),
	('1600 Genessee St','Kansas City','MO','64102'),
	('14 Wall St','New York','NY','10005');
	
INSERT INTO contact (first_name,last_name,phone,email) VALUES
	('Angela','Bonner','9133443422','Angela.Bonner@YRCFreight.com'),
	('Dave','Livergood','3306436876',NULL),
	('Bhavani','Abimannan',NULL,NULL),
	('Jessa','Henry','9177891049','jessa.henry@fdmgroup.com');

INSERT INTO job_listing (position_title,description,listing_link,location_id,company_name) VALUES
	('Software Engineer',NULL,NULL,1,'YRC Freight'),
	('EDI Developer','Assist in the transition of EDI tool Gentran to Sterling integrator',NULL,1,'YRC Freight'),
	('Entry Level Software Engineer',NULL,'https://revature.com/jobs/entry-level-engineer/?utm_source=stackoverflow',2,'Revature'),
	('Junior Software Engineer','Design, develop, code, and test software systems or applications for software enhancements and new products; revise and refine as required','https://umkc-csm.symplicity.com/students/index.php?mode=form&id=f147eb52dd23e054e40d62de29f9fc26&s=jobs&ss=jobs#jobact.apply=1',3,'Retail Software Solutions Group'),
	('Junior Software Developer','Software Developers work with a range of responsibilities, including: writing, developing, testing, and reviewing code; supporting existing applications; liaising with end users to fix defects, find solutions, and test them; adding functionality to applications by designing and implementing solutions; and more. FDM has trained and placed developers in specialties including Java, C#, COBOL, .Net, and more.','https://umkc-csm.symplicity.com/students/index.php?mode=form&id=a6e7b5dfecb081f7e6f10f8462dcb7d3&s=jobs&ss=jobs#jobact.apply=1',4,'FDM Group');

INSERT INTO user_job_listing (user_id,job_listing_id) VALUES (1,1),(1,2),(1,3),(1,4),(1,5);
INSERT INTO contact_job_listing (contact_id,job_listing_id) VALUES(1,1),(1,2),(2,2),(3,3),(4,5);
