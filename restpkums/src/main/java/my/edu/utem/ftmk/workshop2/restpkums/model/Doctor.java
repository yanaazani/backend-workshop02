package my.edu.utem.ftmk.workshop2.restpkums.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "icDoctor")
	private int icDoctor;

	@Column(name="doctorFirstName")
	private String firstName;
	
	@Column(name="doctorLastName")
	private String lastName;
	
	@Column(name="doctorEmail")
	private String email;
	
	@Column(name="rating")
	private int rating;
	
	
	@ManyToOne
	@JoinColumn(name="patientid")
	private Patient patientId;


	public Doctor() {
		
	}
	public Doctor(int icDoctor) {
		this.icDoctor = icDoctor;
	}
	
	public int getIcDoctor() {
		return icDoctor;
	}

	public void setIcDoctor(int icDoctor) {
		this.icDoctor = icDoctor;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}
	
}
