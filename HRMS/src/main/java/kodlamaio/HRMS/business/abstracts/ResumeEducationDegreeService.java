package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeEducationDegree;

public interface ResumeEducationDegreeService {
	
	Result add(ResumeEducationDegree resumeEducationDegree);
	DataResult<List<ResumeEducationDegree>> findAll();

}

