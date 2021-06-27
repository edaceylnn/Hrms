package kodlamaio.HRMS.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.UserPhoto;

public interface UserPhotoService {

	Result addPhoto(MultipartFile file, int candidateId);

	DataResult<UserPhoto> getByCandidateId(int candidateId);

}
