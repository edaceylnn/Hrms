package kodlamaio.HRMS.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="candidates")
public class Candidate extends User {
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birth_year")
	private int birthYear;
	
	@OneToMany(mappedBy = "candidate")
	private List<ResumeEducation> resumeEducation;
	
	@OneToMany(mappedBy = "candidate")
	private List<ResumeSkill> resumeSkill;
	
	@OneToMany(mappedBy = "candidate")
	private List<ResumeLink> resumeLink;
	
	@OneToMany(mappedBy = "candidate")
	private List<ResumeLanguage> resumeLanguage;
	
	@OneToMany(mappedBy = "candidate")
	private List<ResumeCoverLetter> resumeCoverLetter;
	
	@OneToMany(mappedBy = "candidate")
	private List<ResumeExperience> resumeExperience;
	
	@OneToMany(mappedBy = "candidate")
	private List<UserPhoto> userPhoto;
	
	
	


    
}
