package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.ResumeLinkService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeLink;

@RestController
@RequestMapping("/api/resumeLinks")
public class ResumeLinksController {

	private ResumeLinkService resumeLinkService;

	@Autowired
	public ResumeLinksController(ResumeLinkService resumeLinkService) {
		super();
		this.resumeLinkService = resumeLinkService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody ResumeLink resumeLink) {
		return resumeLinkService.add(resumeLink);
	}

	@GetMapping("/getAll")
	DataResult<List<ResumeLink>> getAll() {
		return resumeLinkService.getAll();
	}
}