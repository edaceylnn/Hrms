package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeCoverLetter;


public interface ResumeCoverLetterService {
	
	Result add(ResumeCoverLetter resumeCoverLetter);
	DataResult<List<ResumeCoverLetter>> getAll();
	DataResult<List<ResumeCoverLetter>> getByCandidateId(int candidateId);



}
