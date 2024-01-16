package my.edu.utem.ftmk.workshop2.restpkums.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="feedback")
public class Feedback {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private int id;

	@Column(name="loginTroubleRating")
    private double loginTroubleRating;
	
	@Column(name="repairQualityRating")
    private double repairQualityRating;
	
	@Column(name="efficiencyRating")
    private double efficiencyRating;
	
	@Column(name="personalProfileRating")
    private double personalProfileRating;
	
	@Column(name="comment")
	private String comment;
	
	@Lob
	@Column(name = "image", columnDefinition="LONGBLOB")
	private byte[] image;

	
	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}

	@ManyToOne
	@JoinColumn(name="patientid")
	private Patient patientId;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLoginTroubleRating() {
		return loginTroubleRating;
	}

	public void setLoginTroubleRating(double loginTroubleRating) {
		this.loginTroubleRating = loginTroubleRating;
	}

	public double getRepairQualityRating() {
		return repairQualityRating;
	}

	public void setRepairQualityRating(double repairQualityRating) {
		this.repairQualityRating = repairQualityRating;
	}

	public double getEfficiencyRating() {
		return efficiencyRating;
	}

	public void setEfficiencyRating(double efficiencyRating) {
		this.efficiencyRating = efficiencyRating;
	}

	public double getPersonalProfileRating() {
		return personalProfileRating;
	}

	public void setPersonalProfileRating(double personalProfileRating) {
		this.personalProfileRating = personalProfileRating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}


	
	
}
