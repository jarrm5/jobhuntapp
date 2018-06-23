SELECT u.username,j.position_title,j.company_name,CONCAT(c.first_name,' ', c.last_name) AS contact FROM app_user u 
INNER JOIN user_job_listing uj ON u.user_id = uj.user_id
INNER JOIN job_listing j ON uj.job_listing_id = j.job_listing_id
INNER JOIN contact_job_listing cj ON j.job_listing_id = cj.job_listing_id
INNER JOIN contact c ON cj.contact_id = c.contact_id;