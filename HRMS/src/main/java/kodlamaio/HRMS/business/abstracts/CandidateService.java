package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Candidate;

public interface CandidateService {

	Result add(Candidate candidate);

	DataResult<List<Candidate>> getAll();

	DataResult<Candidate> getByEmail(String email);

	DataResult<Candidate> getByIdentityNumber(String identityNumber);

	DataResult<Candidate> getById(int id);

}
