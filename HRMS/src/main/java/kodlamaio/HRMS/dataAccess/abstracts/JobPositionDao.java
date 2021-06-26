package kodlamaio.HRMS.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
	
	List<JobPosition> findByTitle(String title);

	
}
