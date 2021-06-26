package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.HRMS.entities.concretes.JobAdvertisement;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("From JobAdvertisement where isActive =:isActive")
	List<JobAdvertisement> getByIsActive(boolean isActive);

	@Query("From JobAdvertisement where employer.companyName=:companyName and isActive=:isActive")
	List<JobAdvertisement> getByCompanyNameIsActive(boolean isActive, String companyName);

	@Query("From JobAdvertisement where isActive=:isActive")
	List<JobAdvertisement> getByDateIsActive(boolean isActive);

}
