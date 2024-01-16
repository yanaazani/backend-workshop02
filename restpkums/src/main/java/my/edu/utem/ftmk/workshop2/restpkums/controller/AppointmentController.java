package my.edu.utem.ftmk.workshop2.restpkums.controller;

import java.util.List;

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

import jakarta.transaction.Transactional;
import my.edu.utem.ftmk.workshop2.restpkums.model.Appointment;
import my.edu.utem.ftmk.workshop2.restpkums.repository.AppointmentRepository;

/**
 * This is the appointment controller class
 * @author User
 *
 */
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentRepository appointmentRepos;
	
	@GetMapping("/getappointment/{date}/{time}")
	public List<Appointment> getCertainTimeAppointment(@PathVariable String date, @PathVariable String time){
		return appointmentRepos.getAppointmentListbyCertainTime(date, time);
	}
	
	@GetMapping("/getstatus/{status}/patient/{patientId}")
	public List<Appointment> getByAppointmentStatusId(@PathVariable String status,@PathVariable int patientId) {
	    return appointmentRepos.getByAppointmentStatusId(status, patientId);
	}
	
	
	//return must same as get
	@GetMapping("/validateappointment/{id}/{date}/{time}/{status}/patient/{patientId}")
	public List<Appointment> validateAppointment(@PathVariable int id, @PathVariable String date, @PathVariable String time, @PathVariable String status,@PathVariable int patientId){
		return appointmentRepos.validateAppointment(id, date, time, status, patientId);
	}
	
	@PostMapping("/insertappointment") 
		public Appointment InsertAppointment(@RequestBody Appointment appointment) {
			return appointmentRepos.save(appointment);
		}
	
	@PutMapping("/updateappointment/{id}")
	public ResponseEntity<?> UpdateAppointment(@PathVariable int id, @RequestBody Appointment updatedAppointment) {
		try {
            Appointment existingAppointment = appointmentRepos.findByAppointmentId(id);

            if (existingAppointment == null) {
                return new ResponseEntity<>("This Appointment is not found", HttpStatus.NOT_FOUND);
            }
            
            // Update the status of the existing appointment from the updatedAppointment
            existingAppointment.setStatus(updatedAppointment.getStatus());

            // Save the updated appointment (with only the status modified)
            appointmentRepos.save(existingAppointment);

           
            // return HTTP status response code of 200 means OK
            return new ResponseEntity<>("Appointment updated successfully", HttpStatus.OK);
         
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return new ResponseEntity<>("Error updating appointment", HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@Transactional
	@PutMapping("/updateservicerate/{id}/{serviceRate}")
	public ResponseEntity<?> updateServiceRate(@PathVariable int id, @PathVariable int serviceRate) {
	    try {
	        appointmentRepos.updateServiceRateById(id, serviceRate);
	        return new ResponseEntity<>("Service rate updated successfully", HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the exception for debugging
	        return new ResponseEntity<>("Error updating service rate: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	}



		
}