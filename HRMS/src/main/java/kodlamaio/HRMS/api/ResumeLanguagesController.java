package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.ResumeLanguageService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeLanguage;


@RestController
@RequestMapping("/api/resumeLanguages")
public class ResumeLanguagesController {
	
	private ResumeLanguageService resumeLanguageService;
	
	@Autowired
	public ResumeLanguagesController(ResumeLanguageService resumeLanguageService) {
		this.resumeLanguageService = resumeLanguageService;
	}



	@PostMapping("/add")
	public Result add(@RequestBody ResumeLanguage resumeLanguage) {
		return resumeLanguageService.add(resumeLanguage);
	}

	@GetMapping("/findAllByResumeId")
	DataResult<List<ResumeLanguage>> findAllByResumeId(int resumeId) {
		return resumeLanguageService.findAllByResumeId(resumeId);
	}
	
	@PostMapping("/addAll")
	public Result ResultAdd(List<ResumeLanguage> resumeLanguages) {
		return resumeLanguageService.addAll(resumeLanguages);
		
	}
}