package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Employer;

public interface EmployerService {

	Result add(Employer employer);

	DataResult<List<Employer>> getAll();
	
	DataResult<Employer> getByEmail(String email);
	


}
