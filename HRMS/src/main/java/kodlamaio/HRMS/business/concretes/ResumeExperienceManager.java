package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ResumeExperienceService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ResumeExperienceDao;
import kodlamaio.HRMS.entities.concretes.ResumeExperience;

@Service
public class ResumeExperienceManager implements ResumeExperienceService{

	private ResumeExperienceDao resumeExperienceDao;
	
	@Autowired
	public ResumeExperienceManager(ResumeExperienceDao resumeExperienceDao) {
		super();
		this.resumeExperienceDao = resumeExperienceDao;
	}

	@Override
	public Result add(ResumeExperience resumeExperience) {
		if (resumeExperience.getEndDate() != null && !resumeExperience.getStartedDate().before(resumeExperience.getEndDate())) {
			return new ErrorResult("Bitiş tarihi, başlama tarihiniden önce olamaz"); 
		}
		
		this.resumeExperienceDao.save(resumeExperience);
		return new SuccessResult("Deneyim eklendi");
	}


	@Override
	public DataResult<List<ResumeExperience>> getByCandidateId(int candidateId) {
	
		return new SuccessDataResult<List<ResumeExperience>>(resumeExperienceDao.getByCandidateId(candidateId));
	}

	@Override
	public DataResult<List<ResumeExperience>> getAll() {
		
		return new SuccessDataResult<List<ResumeExperience>>(this.resumeExperienceDao.findAll(),"Data listelendi");
	}



}
