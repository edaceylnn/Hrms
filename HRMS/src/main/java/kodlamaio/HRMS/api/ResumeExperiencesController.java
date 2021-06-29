package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.ResumeExperienceService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeExperience;

@RestController
@RequestMapping("/api/resumeExperiences")
public class ResumeExperiencesController {
	
	private ResumeExperienceService resumeExperienceService;

	public ResumeExperiencesController(ResumeExperienceService resumeExperienceService) {
		super();
		this.resumeExperienceService = resumeExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeExperience resumeExperience) {
		return resumeExperienceService.add(resumeExperience);
	}
	
	@GetMapping("/getAll")
	DataResult<List<ResumeExperience>> getAll() {
		return resumeExperienceService.getAll();
	}


}