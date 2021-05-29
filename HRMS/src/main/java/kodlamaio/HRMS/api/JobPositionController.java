package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.JobPositionService;
import kodlamaio.HRMS.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/job_titles")
public class JobPositionController {
	
	private JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionController(JobPositionService jobTitleService) {
		super();
		this.jobPositionService = jobTitleService;
	}

	@GetMapping("/getall")
	public List<JobPosition> getAll(){
		return this.jobPositionService.getAll();
	}

}
