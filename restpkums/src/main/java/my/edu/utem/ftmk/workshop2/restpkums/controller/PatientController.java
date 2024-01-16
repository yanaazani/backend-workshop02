package my.edu.utem.ftmk.workshop2.restpkums.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.workshop2.restpkums.model.Patient;
import my.edu.utem.ftmk.workshop2.restpkums.repository.PatientRepository;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	/**
	 * web request API
	 *  store in json format => send to local host ex: mysql 8080 (xampp) => fecth data from localhost to json format balik 
	 *  For user patient register their account.
	 */
	@Autowired
	private PatientRepository PatientRepo;
	
	@PostMapping("/signup")
	public Patient Signup(@RequestBody Patient patient) {
		
		return PatientRepo.save(patient);
	}
	
	/*
	 * @PostMapping("/login") private Patient Login(@RequestBody Patient patient) {
	 * 
	 * }
	 */
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Patient patient){
		
		Patient loginPatient = PatientRepo.login(patient.getEmail(), patient.getPassword());
		
		if(loginPatient == null) {
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("This user is not exist");
		}
		else {
			return ResponseEntity.ok().body(loginPatient);
		}
	}
	
	// To list out all the data from mysql to profile page patient
	@GetMapping("/list")
	 public List<Patient> getAllPatients() {
	        return PatientRepo.findAll();
	    }
	
	/**
	 * This method retrieves patient details based on id
	 *
	 *@param Id
	 *@return A list of patient details by id
	 */
	@GetMapping ("/details01/{Id}")
	public Optional<Patient> getPassenger(@PathVariable long Id )
	{
		Optional<Patient> patient = PatientRepo.findById(Id);
		
		return patient;
	}
	
	@GetMapping ("/details/{Id}")
	public Patient getPatient(@PathVariable int Id )
	{
		return PatientRepo.findPatientById(Id);
		
	}
	
	
	@GetMapping ("/email/{email}")
	public Patient getPatientByEmail(@PathVariable String email )
	{
		return PatientRepo.findPatientByEmail(email);
		
	}
	/**
     * Update patient information.
     *
     * @param id             The ID of the patient to update.
     * @param updatedPatient The updated patient information.
     * @return ResponseEntity with appropriate status and message.
     */
    @PutMapping("/edit/{Id}")
    public ResponseEntity<String> updatePatient(
            @PathVariable Long Id,
            @RequestBody Patient updatedPatient
    ) {
        // Check if the patient with the given ID exists
        Optional<Patient> optionalPatient = PatientRepo.findById(Id);
        if (optionalPatient.isEmpty()) {
            return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
        }

        // Get the existing patient
        Patient existingPatient = optionalPatient.get();

        // Update only non-null fields from the request
        if (updatedPatient.getEmail() != null) {
            existingPatient.setEmail(updatedPatient.getEmail());
        }
        if (updatedPatient.getPassword() != null) {
            existingPatient.setPassword(updatedPatient.getPassword());
        }
        if (updatedPatient.getIc() != null) {
            existingPatient.setIc(updatedPatient.getIc());
        }
        if (updatedPatient.getName() != null) {
            existingPatient.setName(updatedPatient.getName());
        }
        if (updatedPatient.getGender() != null) {
            existingPatient.setGender(updatedPatient.getGender());
        }
        if (updatedPatient.getHeight() != null) {
            existingPatient.setHeight(updatedPatient.getHeight());
        }
        if (updatedPatient.getWeight() != null) {
            existingPatient.setWeight(updatedPatient.getWeight());
        }
        if (updatedPatient.getPhone() != null) {
            existingPatient.setPhone(updatedPatient.getPhone());
        }

        // Save the updated patient
        PatientRepo.save(existingPatient);

        // Return a success response
        return new ResponseEntity<>("Patient updated successfully", HttpStatus.OK);
    }
    
    @PutMapping("/updatepassword/{email}")
    public ResponseEntity<String> updatePatientPassword(@PathVariable String email, @RequestBody Map<String, String> requestBody) {
        String newPassword = requestBody.get("password");

        if (newPassword == null) {
            // If the 'password' field is not present in the request body, return an error response
            return new ResponseEntity<>("Password field is required", HttpStatus.BAD_REQUEST);
        }

        Patient patient = PatientRepo.findPatientByEmail(email);
        if (patient == null) {
            // If patient is not found, return an error response
            return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
        }

        // Update the patient's password
        patient.setPassword(newPassword);
        PatientRepo.save(patient);

        return new ResponseEntity<>("Patient updated successfully", HttpStatus.OK);
    }


}


















