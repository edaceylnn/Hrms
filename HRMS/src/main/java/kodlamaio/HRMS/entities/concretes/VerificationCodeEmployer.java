package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="verification_code_employers")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCodeEmployer {

	
	@Id
	@Column(name="id")
	private int id;
	
	
	@Column(name="employer_id")
	private int employerId;
}
