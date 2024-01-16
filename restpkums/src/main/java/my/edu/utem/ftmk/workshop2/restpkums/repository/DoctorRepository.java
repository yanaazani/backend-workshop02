package my.edu.utem.ftmk.workshop2.restpkums.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import my.edu.utem.ftmk.workshop2.restpkums.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	Doctor findByIcDoctor(int icDoctor);
	
	 @Modifying
	    @Transactional
	    @Query(value = "UPDATE Doctor d " +
	            "JOIN ( " +
	            "    SELECT icDoctor, ROUND(AVG(rating)) AS roundedAverageRating " +
	            "    FROM feedbackdoctor " +
	            "    GROUP BY icDoctor " +
	            ") AS subquery ON d.icDoctor = subquery.icDoctor " +
	            "SET d.rating = subquery.roundedAverageRating", nativeQuery = true)
	    void updateDoctorRatings();
	
}
