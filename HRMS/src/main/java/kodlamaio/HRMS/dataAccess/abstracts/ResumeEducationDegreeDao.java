package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.ResumeEducationDegree;

public interface ResumeEducationDegreeDao extends JpaRepository<ResumeEducationDegree,Integer>{

	
}

