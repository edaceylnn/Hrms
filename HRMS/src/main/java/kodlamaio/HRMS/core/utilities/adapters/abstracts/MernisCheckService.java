package kodlamaio.HRMS.core.utilities.adapters.abstracts;

import kodlamaio.HRMS.entities.concretes.Candidate;

public interface MernisCheckService {
	boolean checkIfRealPerson(Candidate candidate);
}
