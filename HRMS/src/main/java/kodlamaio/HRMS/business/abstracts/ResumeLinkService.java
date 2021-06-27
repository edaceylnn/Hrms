package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeLink;

public interface ResumeLinkService {

	Result add(ResumeLink resumeLink);
	DataResult<List<ResumeLink>> findAllByResumeId(int resumeId);
	Result addAll(List<ResumeLink> resumeLinks);
}
