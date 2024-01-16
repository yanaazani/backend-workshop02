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
@Table(name="feedbackdoctor")
public class FeedbackDoctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="review")
	private String review;
	
	@ManyToOne
	@JoinColumn(name="patientid")
	private Patient patientId;
	
	@ManyToOne
	@JoinColumn(name="icDoctor")
	private Doctor icDoctor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}


	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}

	public Doctor getIcDoctor() {
		return icDoctor;
	}

	public void setIcDoctor(Doctor icDoctor) {
		this.icDoctor = icDoctor;
	}
	
}
