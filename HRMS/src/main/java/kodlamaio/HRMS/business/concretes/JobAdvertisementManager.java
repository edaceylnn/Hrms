package kodlamaio.HRMS.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;

import kodlamaio.HRMS.dataAccess.abstracts.JobAdvertisementDao;

import kodlamaio.HRMS.entities.concretes.JobAdvertisement;


@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;

	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		String date = LocalDate.now().toString();
		jobAdvertisement.setReleaseDate(date);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Data eklendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Data getirildi.");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActive(), "Aktif data getirildi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedByDeadline() {
		return new SuccessDataResult<List<JobAdvertisement>>(
				jobAdvertisementDao.getByDateIsActive());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByCompanyNameIsActive(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				jobAdvertisementDao.getByCompanyNameIsActive(companyName),"Data getirildi.");

	}

	@Override
	public Result update(int id, boolean isActive) {

		JobAdvertisement jobAdvertisementUpdate = this.jobAdvertisementDao.findById(id).get();
		jobAdvertisementUpdate.setActive(isActive);
		this.jobAdvertisementDao.save(jobAdvertisementUpdate);
		return new SuccessResult("Aktiflik değiştirildi.");
	}


}