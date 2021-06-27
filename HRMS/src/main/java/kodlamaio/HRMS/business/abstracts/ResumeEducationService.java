package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeEducation;

public interface ResumeEducationService {
	
	Result add(ResumeEducation resumeEducation);
	DataResult<List<ResumeEducation>> findAllByResumeId(int resumeId);
	DataResult<List<ResumeEducation>> findAllByResumeIdOrderByEndDateDesc(int resumeId);
	Result addAll(List<ResumeEducation> resumeEducations);

}
