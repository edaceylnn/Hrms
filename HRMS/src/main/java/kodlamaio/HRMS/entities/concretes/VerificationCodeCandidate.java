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
@Table(name="verification_code_candidates")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCodeCandidate {

	@Id
	@Column(name="id")
	private int id;
	
	
	@Column(name="candidate_id")
	private int candidateId;
}
