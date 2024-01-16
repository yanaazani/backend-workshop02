package my.edu.utem.ftmk.workshop2.restpkums.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.workshop2.restpkums.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {


}
