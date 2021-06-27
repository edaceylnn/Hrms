package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ResumeEducationDegreeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ResumeEducationDegreeDao;
import kodlamaio.HRMS.entities.concretes.ResumeEducationDegree;

@Service
public class ResumeEducationDegreeManager implements ResumeEducationDegreeService{
	
	private ResumeEducationDegreeDao resumeEducationDegreeDao;

	@Autowired
	public ResumeEducationDegreeManager(ResumeEducationDegreeDao resumeEducationDegreeDao) {
		super();
		this.resumeEducationDegreeDao = resumeEducationDegreeDao;
	}

	@Override
	public Result add(ResumeEducationDegree resumeEducationDegree) {
		this.resumeEducationDegreeDao.save(resumeEducationDegree);
		return new SuccessResult("Eğitim derecesi eklendi");
	}

	@Override
	public DataResult<List<ResumeEducationDegree>> findAll() {
		return new SuccessDataResult<List<ResumeEducationDegree>>(resumeEducationDegreeDao.findAll(),"Listelendi");
	}

}
