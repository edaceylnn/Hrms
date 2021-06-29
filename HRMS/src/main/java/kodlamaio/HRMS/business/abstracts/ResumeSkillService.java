package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeSkill;

public interface ResumeSkillService {

	Result add(ResumeSkill resumeSkill);

	DataResult<List<ResumeSkill>> getAll();

	DataResult<List<ResumeSkill>> getByCandidateId(int candidateId);

}
