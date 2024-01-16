package my.edu.utem.ftmk.workshop2.restpkums.model;

import jakarta.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="email")
	private String Email;
	
	//write only will prevent user password from being returned in request
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name="password")
	private String Password;
	
	@Column(name="ic")
	private String Ic;
	
	@Column(name="fullname")
	private String Name;
	
	@Column(name="gender")
	private String Gender;
	
	//@Column(name="birthday")
	//private String Birthday;
	
	@Column(name="height")
	private String Height;
	

	public Patient() {
		
	}
	public Patient(int Id) {
		this.Id = Id;
	}
	
	
	public String getHeight() {
		return Height;
	}
	public void setHeight(String height) {
		Height = height;
	}
	public String getWeight() {
		return Weight;
	}
	public void setWeight(String weight) {
		Weight = weight;
	}
	@Column(name="weight")
	private String Weight;
	
	@Column(name="phone")
	private String Phone;
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getIc() {
		return Ic;
	}
	public void setIc(String ic) {
		Ic = ic;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	

}