package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeLanguage;

public interface ResumeLanguageService {

	Result add(ResumeLanguage resumeLanguage);
	DataResult<List<ResumeLanguage>> findAllByResumeId(int resumeId);
	Result addAll(List<ResumeLanguage> resumeLanguage);
}
