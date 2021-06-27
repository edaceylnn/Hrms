package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeExperience;

public interface ResumeExperienceService {
	
	Result add(ResumeExperience resumeExperience);
	DataResult<List<ResumeExperience>> findAllByResumeId(int resumeId);
	DataResult<List<ResumeExperience>> findAllByResumeIdOrderByEndDateDesc(int resumeId);
	Result addAll(List<ResumeExperience> resumeExperiences);

}
