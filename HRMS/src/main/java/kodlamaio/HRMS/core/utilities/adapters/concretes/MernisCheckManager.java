package kodlamaio.HRMS.core.utilities.adapters.concretes;


import org.springframework.stereotype.Service;

import kodlamaio.HRMS.core.utilities.adapters.abstracts.MernisCheckService;
import kodlamaio.HRMS.entities.concretes.Candidate;


@Service
public class MernisCheckManager implements MernisCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		return true;

	}
}