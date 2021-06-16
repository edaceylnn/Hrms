package kodlamaio.HRMS.business.concretes;

import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.AuthService;
import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.core.utilities.adapters.abstracts.MernisCheckService;
import kodlamaio.HRMS.core.utilities.adapters.abstracts.VerificationCodeService;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateDao;

import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.concretes.Employer;

@Service
public class AuthManager implements AuthService {

	private EmployerService employerService;
	private CandidateService candidateService;
	private VerificationCodeService verificationCodeService;
	private CandidateDao candidateDao;
	private MernisCheckService mernisCheckService;

	@Autowired
	public AuthManager(EmployerService employerService, CandidateService candidateService,
			VerificationCodeService verificationCodeService, CandidateDao candidateDao,
			MernisCheckService mernisCheckService) {
		super();
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.verificationCodeService = verificationCodeService;
		this.candidateDao = candidateDao;

		this.mernisCheckService = mernisCheckService;
	}

	private boolean validationForCandidate(Candidate candidate) {
		if (Objects.isNull(candidate.getIdentityNumber()) || Objects.isNull(candidate.getFirstName())
				|| Objects.isNull(candidate.getLastName()) || Objects.isNull(candidate.getEmail())
				|| Objects.isNull(candidate.getPassword()) || Objects.isNull(candidate.getBirthYear())) {

			return false;
		}
		return true;
	}

	private boolean validationForEmployer(Employer employer) {
		if (Objects.isNull(employer.getCompanyName()) || Objects.isNull(employer.getWebAddress())
				|| Objects.isNull(employer.getEmail()) || Objects.isNull(employer.getPassword())) {

			return false;
		}
		return true;
	}

	public boolean confirmPassword(String password, String confirmPassword) {
		if (password.equals(confirmPassword)) {

			return true;
		}
		return false;
	}

	private boolean checkIfEmailExists(String email) {
		if (this.candidateDao.getByEmail(email) != null) {
			return false;
		}
		return true;
	}

	private boolean checkIfNationalIdentityExists(String identityNumber) {
		if (this.candidateDao.getByIdentityNumber(identityNumber) != null) {
			return false;
		}
		return true;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {

		if (!validationForEmployer(employer)) {
			return new ErrorResult("Tüm alanlar zorunludur.");
		}
		else if (!employer.getWebAddress().contains(employer.getEmail().split("@")[0])) {
			return new ErrorResult("Aynı domaine sahip değil.");
		}
		else if (!checkIfEmailExists(employer.getEmail())) {
			return new ErrorResult("Kullanılmış bir e-posta adresi.");
		} 
		else if (!confirmPassword(employer.getPassword(), confirmPassword)) {
			return new ErrorResult("Şifre eşleşmiyor. lütfen şifrenizi tekrar girin");
		}
		
	
		var result = this.employerService.add(employer);

		if (result.isSuccess()) {
			if (this.verificationCodeService.sendVerificationCode(employer.getEmail())) {
				return new SuccessResult("İşveren Kayıtlı");
			}
		}

		return new ErrorResult("Kayıt başarısız");

	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmPassword) {
		if (!mernisCheckService.checkIfRealPerson(candidate)) {
			if (!validationForCandidate(candidate)) {
				return new ErrorResult("Tüm alanlar zorunludur.");
			}
		} else if (!checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult("Kullanılmış bir e-posta adresi.");
		} else if (!checkIfNationalIdentityExists(candidate.getIdentityNumber())) {
			return new ErrorResult("Kimlik numaranızı tekrar kontrol ediniz.");
		} else if (!confirmPassword(candidate.getPassword(), confirmPassword)) {

			return new ErrorResult("Şifre eşleşmiyor. Lütfen şifrenizi tekrar girin.");
		}
		var result = this.candidateService.add(candidate);

		if (result.isSuccess()) {
			if (verificationCodeService.sendVerificationCode(candidate.getEmail())) {
				return new SuccessResult("Aday kayıtlı.");
			}
		}

		return new ErrorResult("Başarısız.");
	}

}
