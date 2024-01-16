package my.edu.utem.ftmk.workshop2.restpkums.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.workshop2.restpkums.model.FeedbackDoctor;

public interface FeedbackDoctorRepository extends JpaRepository<FeedbackDoctor, Long> {
	
	//FeedbackDoctor findByIcDoctor(int icDoctor);
	
}
