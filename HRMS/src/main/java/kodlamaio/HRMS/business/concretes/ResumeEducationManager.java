package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ResumeEducationService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ResumeEducationDao;
import kodlamaio.HRMS.entities.concretes.ResumeEducation;

@Service
public class ResumeEducationManager  implements ResumeEducationService{

	private ResumeEducationDao resumeEducationDao;
	
	@Autowired
	public ResumeEducationManager(ResumeEducationDao resumeEducationDao) {
		super();
		this.resumeEducationDao = resumeEducationDao;
	}

	@Override
	public Result add(ResumeEducation resumeEducation) {
		
		if (resumeEducation.getEndDate() != null && !resumeEducation.getStartedDate().before(resumeEducation.getEndDate())) {
			return new ErrorResult("Bitiş tarihi, başlama tarihiniden önce olamaz"); 
		}
		
		resumeEducationDao.save(resumeEducation);
		return new SuccessResult("Eğitim bilgisi eklendi");
	}

	@Override
	public DataResult<List<ResumeEducation>> getByCandidateId(int candidateId) {
	
		return new SuccessDataResult<List<ResumeEducation>>(resumeEducationDao.getByCandidateId(candidateId));
	}

	@Override
	public DataResult<List<ResumeEducation>> getAll() {
		return new SuccessDataResult<List<ResumeEducation>>(this.resumeEducationDao.findAll(),"Data listelendi");
	}

}
