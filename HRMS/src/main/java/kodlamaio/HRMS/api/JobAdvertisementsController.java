package kodlamaio.HRMS.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;



@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;


	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
		
	}
	
	@GetMapping("/GetAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return jobAdvertisementService.getAll();
	}
	
	@GetMapping("/GetAllActive")
	public DataResult<List<JobAdvertisement>> getByIsActive(){
		return jobAdvertisementService.getByIsActive();
	}
	
	@PostMapping("/Add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
	
		return jobAdvertisementService.add(jobAdvertisement);
	}
	
	
	@GetMapping("/GetAllSortedByDeadline")
	public DataResult<List<JobAdvertisement>> getAllSortedByDeadline(){
		return jobAdvertisementService.getAllSortedByDeadline();
	}
	
	@GetMapping("/getBycompanyNameAndIsActive")
	public DataResult<List<JobAdvertisement>> getBycompanyNameAndIsActive(@RequestParam("companyName") String companyName){
		return jobAdvertisementService.getByCompanyNameIsActive(companyName);
	}
	
	@PostMapping("/IsActive")
	public Result update(int id,boolean isActive) {
		return jobAdvertisementService.update(id, isActive);
	}

}