package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.ResumeCoverLetterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ResumeCoverLetter;

@RestController
@RequestMapping("/api/resumeCoverLetters")
public class ResumeCoverLettersController {

	private ResumeCoverLetterService resumeCoverLetterService;

	@Autowired
	public ResumeCoverLettersController(ResumeCoverLetterService resumeCoverLetterService) {
		super();
		this.resumeCoverLetterService = resumeCoverLetterService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeCoverLetter resumeCoverLetter) {
		return resumeCoverLetterService.add(resumeCoverLetter);
	}
	
	@GetMapping("/geetAll")
	DataResult<List<ResumeCoverLetter>> getAll() {
		return this.resumeCoverLetterService.getAll();
	}
	
}