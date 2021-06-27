package kodlamaio.HRMS.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.business.abstracts.UserPhotoService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.UserPhoto;

@RestController
@RequestMapping("/api/userPhotos")
@CrossOrigin
public class UserPhotosController {
	
	private UserPhotoService userPhotoService;

	@Autowired
	public UserPhotosController(UserPhotoService userPhotoService) {
		super();
		this.userPhotoService = userPhotoService;
	}
	
	@PostMapping("/addPhoto")
	public Result addPhoto(MultipartFile file, int candidateId) {
		return userPhotoService.addPhoto(file, candidateId);
	}

    @GetMapping("getByCandidateId")
    public DataResult<UserPhoto> getByCandidateId(@RequestParam int candidateId){
        return userPhotoService.getByCandidateId(candidateId);
    }
    
}
