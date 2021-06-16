package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.User;

public interface UserService {

	Result add(User user);
	DataResult<List<User>> getAll();
	DataResult<User> getById(int id);


}
