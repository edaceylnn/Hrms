package kodlamaio.HRMS.core.utilities.cloudinary;

import org.springframework.stereotype.Component;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileOutputStream;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;


@Component
public class CloudinaryManager implements CloudinaryService{
    private final Cloudinary cloudinary;

    public CloudinaryManager() {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name","eda665" );
        valuesMap.put("api_key", "436332937288986" );
        valuesMap.put("api_secret","Jh6cKdv62ta1zgxRzGBYLGUb1JA" );
        cloudinary = new Cloudinary(valuesMap);
    }

    public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
        File file;
        try {
            file = convert(multipartFile);
            Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return new SuccessDataResult<>(result);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<>("Dosya yüklenemedi");
        }
    }

    public DataResult<Map> delete (String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
        return new SuccessDataResult<>(result);
    }


    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }

}