package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ResumeCoverLetterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ResumeCoverLetterDao;
import kodlamaio.HRMS.entities.concretes.ResumeCoverLetter;

@Service
public class ResumeCoverLetterManager implements ResumeCoverLetterService{
	

	private ResumeCoverLetterDao resumeCoverLetterDao;

	@Autowired
	public ResumeCoverLetterManager(ResumeCoverLetterDao resumeCoverLetterDao) {
		super();
		this.resumeCoverLetterDao = resumeCoverLetterDao;
	}

	@Override
	public Result add(ResumeCoverLetter resumeCoverLetter) {
		this.resumeCoverLetterDao.save(resumeCoverLetter);
		return new SuccessResult("Ön yazı eklendi");
	}

	@Override
	public DataResult<List<ResumeCoverLetter>> getAll() {
		return new SuccessDataResult<List<ResumeCoverLetter>>(this.resumeCoverLetterDao.findAll(),"Data listelendi");
	}



}
