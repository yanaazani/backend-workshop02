package my.edu.utem.ftmk.workshop2.restpkums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import my.edu.utem.ftmk.workshop2.restpkums.model.FeedbackDoctor;
import my.edu.utem.ftmk.workshop2.restpkums.repository.FeedbackDoctorRepository;

@RestController
@RequestMapping("/feedbackdoctor")
public class FeedbackDoctorController {
	
	@Autowired
	private FeedbackDoctorRepository feedbackDoctorRepository;
	
	@PostMapping("/insert") 
	public FeedbackDoctor InsertFeedbackDoctor(@RequestBody FeedbackDoctor feedbackDoctor) {
		return feedbackDoctorRepository.save(feedbackDoctor);
	}

}
