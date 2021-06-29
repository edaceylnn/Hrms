package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ResumeLinkService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ResumeLinkDao;
import kodlamaio.HRMS.entities.concretes.ResumeLink;

@Service
public class ResumeLinkManager implements ResumeLinkService{

	private ResumeLinkDao resumeLinkDao;
	
	@Autowired
	public ResumeLinkManager(ResumeLinkDao resumeLinkDao) {
		super();
		this.resumeLinkDao = resumeLinkDao;
	}

	@Override
	public Result add(ResumeLink resumeLink) {
		
		resumeLinkDao.save(resumeLink);
		return new SuccessResult("Link eklendi");
	}


	@Override
	public DataResult<List<ResumeLink>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<ResumeLink>>(resumeLinkDao.getByCandidateId(candidateId));
	}

	@Override
	public DataResult<List<ResumeLink>> getAll() {
	
		return new SuccessDataResult<List<ResumeLink>>(this.resumeLinkDao.findAll(),"Data listelendi");
	}
}
