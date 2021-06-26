package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.HRMS.entities.concretes.JobAdvertisement;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("From JobAdvertisement where isActive =true")
	List<JobAdvertisement> getByIsActive();

	@Query("From JobAdvertisement where employer.companyName=:companyName and isActive=true")
	List<JobAdvertisement> getByCompanyNameIsActive( String companyName);

	@Query("From JobAdvertisement where isActive= true")
	List<JobAdvertisement> getByDateIsActive();

}
