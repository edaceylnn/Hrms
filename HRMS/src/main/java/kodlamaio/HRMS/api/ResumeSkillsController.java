package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.ResumeSkillService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeSkill;

@RestController
@RequestMapping("/api/resumeSkills")
public class ResumeSkillsController {

	private ResumeSkillService resumeSkillService;

	@Autowired
	public ResumeSkillsController(ResumeSkillService resumeSkillService) {
		super();
		this.resumeSkillService = resumeSkillService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody ResumeSkill resumeSkillDto) {
		return resumeSkillService.add(resumeSkillDto);
	}

	@GetMapping("/getAll")
	DataResult<List<ResumeSkill>> getAll() {
		return resumeSkillService.getAll();
	}
}