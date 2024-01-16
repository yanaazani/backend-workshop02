package my.edu.utem.ftmk.workshop2.restpkums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.workshop2.restpkums.model.Feedback;
import my.edu.utem.ftmk.workshop2.restpkums.repository.FeedbackRepository;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@PostMapping("/add")
	public Feedback AddFeedback(@RequestBody Feedback feedback) {
		
		return feedbackRepository.save(feedback);
	}

}
