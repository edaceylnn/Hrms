package kodlamaio.HRMS.core.utilities.adapters.concretes;



import java.util.UUID;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.core.utilities.adapters.abstracts.VerificationCodeService;

@Service
public class VerificationCodeManager implements VerificationCodeService {

    @Override
    public boolean sendVerificationCode(String emailAddress) {
        UUID uuid = UUID.randomUUID();
        String code = uuid.toString();
        System.out.println(emailAddress+"Adrese doğrulama kodu gönderildi.");
        System.out.println("Doğrulama kodu:"+ code);
        return true;
    }

}