package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.UserPhoto;

public interface UserPhotoDao extends JpaRepository<UserPhoto, Integer>{
	
	UserPhoto getByCandidateId(int candidateId);

}