package kodlamaio.HRMS.core.utilities.cloudinary;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.core.utilities.results.DataResult;


public interface CloudinaryService {

    DataResult<Map<String, String>> upload(MultipartFile file);


}