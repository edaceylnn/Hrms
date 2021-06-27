package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeSkill;

public interface ResumeSkillService {

	Result add(ResumeSkill resumeSkill);
	DataResult<List<ResumeSkill>> findAllByResumeId(int resumeId);
	Result addAll(List<ResumeSkill> resumeSkills);
}
