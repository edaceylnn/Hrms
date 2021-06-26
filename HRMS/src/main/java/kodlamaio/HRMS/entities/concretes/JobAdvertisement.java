package kodlamaio.HRMS.entities.concretes;






import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "job_advertisement")
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class JobAdvertisement {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	

	@Column(name="job_definition")
	private String JobDefinition;
	
	@Column(name="min_salary")
	private int minsalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	

	@Column(name="number_of_open_positions")
	private int numberOfOpenPosition;
	
	@Column(name="application_deadline")
	private String  applicationDeadline;
	
	@Column(name="release_date")
	private String  releaseDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")  
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")  
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "job_position_id")  
	private JobPosition jobPosition;

}
