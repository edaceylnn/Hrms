package kodlamaio.HRMS.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.HRMS.business.abstracts.CandidateService;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;


import kodlamaio.HRMS.dataAccess.abstracts.CandidateDao;

import kodlamaio.HRMS.entities.concretes.Candidate;


@Service
public class CandidateManager implements CandidateService {

	
	private CandidateDao candidateDao;


	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	
	}
	
	@Override
	public Result add(Candidate candidate) {

		this.candidateDao.save(candidate);
		return new SuccessResult("İşveren başarıyla eklendi.");
	}


	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}


	@Override
	public DataResult<Candidate> getByEmail(String email) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getByEmail(email));
	}


	@Override
	public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getByIdentityNumber(identityNumber));
	}


	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(id));
	}


}