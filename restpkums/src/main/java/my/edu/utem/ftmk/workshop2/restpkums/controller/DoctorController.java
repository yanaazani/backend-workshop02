package my.edu.utem.ftmk.workshop2.restpkums.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import my.edu.utem.ftmk.workshop2.restpkums.model.Doctor;
import my.edu.utem.ftmk.workshop2.restpkums.repository.DoctorRepository;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	// To list out all the data from mysql to profile page patient
		@GetMapping("/list")
		 public List<Doctor> getAllDoctors() {
		        return doctorRepository.findAll();
		    }
		
		 @GetMapping("/updateRatings")
		    @Transactional
		    public String updateDoctorRatings() {
		        try {
		            // Execute the update query
		            doctorRepository.updateDoctorRatings();

		            return "Doctor ratings updated successfully!";
		        } catch (Exception e) {
		            e.printStackTrace();
		            return "Error updating doctor ratings.";
		        }
		    }
	
		
		
}
