package kodlamaio.HRMS.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.AuthService;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired 
    public AuthController(AuthService authService) {
        super();
        this.authService = authService;
    }

    @PostMapping("/registerEmployer")
    public Result registerEmployer(@RequestBody Employer employer, String confirmPassword) {
        return this.authService.registerEmployer(employer, confirmPassword);
    }


    @PostMapping("/registerCandidate")
    public Result registerCandidate(@RequestBody Candidate candidate , String confirmPassword) {
        return this.authService.registerCandidate (candidate, confirmPassword);
    }

}
