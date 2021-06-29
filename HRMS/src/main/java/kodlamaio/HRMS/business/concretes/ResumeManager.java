package kodlamaio.HRMS.business.concretes;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.business.abstracts.ResumeCoverLetterService;
import kodlamaio.HRMS.business.abstracts.ResumeEducationService;
import kodlamaio.HRMS.business.abstracts.ResumeExperienceService;
import kodlamaio.HRMS.business.abstracts.ResumeLanguageService;
import kodlamaio.HRMS.business.abstracts.ResumeLinkService;
import kodlamaio.HRMS.business.abstracts.ResumeService;
import kodlamaio.HRMS.business.abstracts.ResumeSkillService;
import kodlamaio.HRMS.business.abstracts.UserPhotoService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.entities.dtos.ResumeDto;

@Service
public class ResumeManager implements ResumeService {

	private CandidateService candidateService;
	private ResumeLinkService resumeLinkService;
	private UserPhotoService userPhotoService;
	private ResumeEducationService resumeEducationService;
	private ResumeExperienceService resumeExperienceService;
	private ResumeSkillService resumeSkillService;
	private ResumeLanguageService resumeLanguageService;
	private ResumeCoverLetterService resumeCoverLetterService;

	@Autowired
	public ResumeManager(CandidateService candidateService, ResumeLinkService resumeLinkService,
			UserPhotoService userPhotoService, ResumeEducationService resumeEducationService,
			ResumeExperienceService resumeExperienceService, ResumeSkillService resumeSkillService,
			ResumeLanguageService resumeLanguageService, ResumeCoverLetterService resumeCoverLetterService) {
		super();
		this.candidateService = candidateService;
		this.resumeLinkService = resumeLinkService;
		this.userPhotoService = userPhotoService;
		this.resumeEducationService = resumeEducationService;
		this.resumeExperienceService = resumeExperienceService;
		this.resumeSkillService = resumeSkillService;
		this.resumeLanguageService = resumeLanguageService;
		this.resumeCoverLetterService = resumeCoverLetterService;
	}

	@Override
	public DataResult<ResumeDto> getByCandidateId(int candidateId) {
		var resume = new ResumeDto();
		resume.setCandidate(candidateService.getById(candidateId).getData());
		resume.setResumeLink(resumeLinkService.getByCandidateId(candidateId).getData());
		resume.setResumeLanguage(resumeLanguageService.getByCandidateId(candidateId).getData());
		resume.setImageUrl(userPhotoService.getByCandidateId(candidateId).getData().getPhotoUrl());
		resume.setCreationDate(LocalDate.now());
		resume.setResumeEducation(resumeEducationService.getByCandidateId(candidateId).getData());
		resume.setResumeSkill(resumeSkillService.getByCandidateId(candidateId).getData());
		resume.setResumeExperience(resumeExperienceService.getByCandidateId(candidateId).getData());
		resume.setResumeCoverLetter(resumeCoverLetterService.getByCandidateId(candidateId).getData());
		
		return new SuccessDataResult<>(resume);
		

	}


}
