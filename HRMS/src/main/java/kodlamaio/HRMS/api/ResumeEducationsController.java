package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.ResumeEducationService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeEducation;

@RestController
@RequestMapping("/api/resumeEducations")
public class ResumeEducationsController {
	
	private ResumeEducationService resumeEducationService;

	@Autowired
	public ResumeEducationsController(ResumeEducationService resumeEducationService) {
		super();
		this.resumeEducationService = resumeEducationService;
	}
	

	@PostMapping("/add")
	public Result add(@RequestBody ResumeEducation resumeEducation) {
		return resumeEducationService.add(resumeEducation);
	}
	
	@GetMapping("/findAllByResumeId")
	DataResult<List<ResumeEducation>> findAllByResumeId(int resumeId) {
		return resumeEducationService.findAllByResumeId(resumeId);
	}
	
	@GetMapping("/findAllByResumeIdOrderByEndDateDesc")
	DataResult<List<ResumeEducation>> findAllByResumeIdOrderByEndDateDesc(int resumeId){
		return resumeEducationService.findAllByResumeIdOrderByEndDateDesc(resumeId);
	}
}