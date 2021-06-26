package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;


public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);

	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisement>> getByIsActive();

	DataResult<List<JobAdvertisement>> getAllSortedByDeadline();

	DataResult<List<JobAdvertisement>> getByCompanyNameIsActive(String companyName);

	Result update(int id, boolean isActive);

}
