package kodlamaio.HRMS.entities.dtos;

import java.time.LocalDate;
import java.util.List;

import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.concretes.ResumeCoverLetter;
import kodlamaio.HRMS.entities.concretes.ResumeEducation;
import kodlamaio.HRMS.entities.concretes.ResumeExperience;
import kodlamaio.HRMS.entities.concretes.ResumeLanguage;
import kodlamaio.HRMS.entities.concretes.ResumeLink;
import kodlamaio.HRMS.entities.concretes.ResumeSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {

    private Candidate candidate;

    private LocalDate creationDate;

    private String imageUrl;

    private List<ResumeEducation> resumeEducation;

    private List<ResumeExperience> resumeExperience;

    private List<ResumeSkill> resumeSkill;

    private List<ResumeLanguage> resumeLanguage;
    
    private List<ResumeLink> resumeLink;
    
    private List<ResumeCoverLetter> resumeCoverLetter;
}

