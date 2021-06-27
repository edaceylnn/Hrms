package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ResumeLanguageService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ResumeLanguageDao;
import kodlamaio.HRMS.entities.concretes.ResumeLanguage;

@Service
public class ResumeLanguageManager  implements ResumeLanguageService{

	private ResumeLanguageDao resumeLanguageDao;
	
	@Autowired
	public ResumeLanguageManager(ResumeLanguageDao resumeLanguageDao) {
		super();
		this.resumeLanguageDao = resumeLanguageDao;
	}

	@Override
	public Result add(ResumeLanguage resumeLanguage) {
		resumeLanguageDao.save(resumeLanguage);
		return new SuccessResult("Dil eklendi");
	}

	@Override
	public DataResult<List<ResumeLanguage>> findAllByResumeId(int resumeId) {
		return new SuccessDataResult<List<ResumeLanguage>>(resumeLanguageDao.findAllByResumeId(resumeId),"Diller listelendi");
	}

	@Override
	public Result addAll(List<ResumeLanguage> resumeLanguage) {
		resumeLanguageDao.saveAll(resumeLanguage);
		return new SuccessResult("Diller eklendi");
	}



}
