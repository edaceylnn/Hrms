package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeExperience;

public interface ResumeExperienceService {

	Result add(ResumeExperience resumeExperience);

	DataResult<List<ResumeExperience>> getAll();

	DataResult<List<ResumeExperience>> getByCandidateId(int candidateId);

}
