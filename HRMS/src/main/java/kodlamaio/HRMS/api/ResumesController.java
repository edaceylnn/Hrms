package kodlamaio.HRMS.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.HRMS.business.abstracts.ResumeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.dtos.ResumeDto;


@RestController
@RequestMapping("/api/resume")
public class ResumesController {

	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	

	@GetMapping("/getByResume")
	public DataResult<ResumeDto> getByCandidateId(@RequestParam int candidateId){
		return this.resumeService.getByCandidateId(candidateId);
	}
	
	
}
