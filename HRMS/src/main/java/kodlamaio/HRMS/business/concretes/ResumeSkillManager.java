package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ResumeSkillService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ResumeSkillDao;
import kodlamaio.HRMS.entities.concretes.ResumeSkill;

@Service
public class ResumeSkillManager implements ResumeSkillService {

	private ResumeSkillDao resumeSkillDao;


	@Autowired
	public ResumeSkillManager(ResumeSkillDao resumeSkillDao) {
		super();
		this.resumeSkillDao = resumeSkillDao;
	
	}

	@Override
	public Result add(ResumeSkill resumeSkill) {
		
		resumeSkillDao.save(resumeSkill);
		
		return new SuccessResult("Yetenek eklendi");
	}

	@Override
	public DataResult<List<ResumeSkill>> findAllByResumeId(int resumeId) {
		
		return new SuccessDataResult<List<ResumeSkill>>(resumeSkillDao.findAllByResumeId(resumeId),"Yetenekler listelendi");
	}

	@Override
	public Result addAll(List<ResumeSkill> resumeSkills) {
		resumeSkillDao.saveAll(resumeSkills);
		return new SuccessResult("Yetenekler eklendi");
	}

	

}