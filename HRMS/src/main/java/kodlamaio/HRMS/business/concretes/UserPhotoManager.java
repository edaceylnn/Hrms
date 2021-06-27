package kodlamaio.HRMS.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.business.abstracts.UserPhotoService;
import kodlamaio.HRMS.core.utilities.cloudinary.CloudinaryService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.UserPhotoDao;


import kodlamaio.HRMS.entities.concretes.UserPhoto;

@Service
public class UserPhotoManager implements UserPhotoService {
	
	private UserPhotoDao userPhotoDao;
	private CloudinaryService cloudinaryService;
	private CandidateService candidateService;
	
	@Autowired
	public UserPhotoManager(UserPhotoDao userPhotoDao, CloudinaryService cloudinaryService,CandidateService candidateService) {
		super();
		this.userPhotoDao = userPhotoDao;
		this.cloudinaryService = cloudinaryService;
		this.candidateService = candidateService;
	}


	@Override
	public Result addPhoto(MultipartFile file, int candidateId) {
		
        var result = this.cloudinaryService.upload(file);
        if(!result.isSuccess()) {
            return new ErrorResult();
        }
        UserPhoto photo = new UserPhoto();
        photo.setCandidate(candidateService.getById(candidateId).getData());
        photo.setPhotoUrl(result.getData().get("url"));
        this.userPhotoDao.save(photo);
        return new SuccessResult("Fotoğraf eklendi");
	}


	@Override
	public DataResult<UserPhoto> getByCandidateId(int candidateId) {
		
		return new SuccessDataResult<UserPhoto>(userPhotoDao.getByCandidateId(candidateId));
	}







}
