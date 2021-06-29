package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.ResumeEducation;

public interface ResumeEducationDao extends JpaRepository<ResumeEducation, Integer>{
	
	List<ResumeEducation> getByCandidateId(int candidateId);

}