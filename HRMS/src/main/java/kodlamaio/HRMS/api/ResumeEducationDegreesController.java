package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.ResumeEducationDegreeService;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeEducationDegree;

@RestController
@RequestMapping("/api/resumeEducationDegrees")
public class ResumeEducationDegreesController {

	private ResumeEducationDegreeService resumeEducationDegreeService;

	@Autowired
	public ResumeEducationDegreesController(ResumeEducationDegreeService resumeEducationDegreeService) {
		super();
		this.resumeEducationDegreeService = resumeEducationDegreeService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody ResumeEducationDegree resumeEducationDegree) {
		return resumeEducationDegreeService.add(resumeEducationDegree);
	}
	
	@GetMapping("/findAll")
	DataResult<List<ResumeEducationDegree>> findAll() {
		return resumeEducationDegreeService.findAll();
	}
}