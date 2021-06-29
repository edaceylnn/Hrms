package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.dtos.ResumeDto;

public interface ResumeService {

	DataResult<ResumeDto> getByCandidateId(int candidateId);
}
