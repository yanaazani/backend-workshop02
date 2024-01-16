package my.edu.utem.ftmk.workshop2.restpkums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import my.edu.utem.ftmk.workshop2.restpkums.model.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long> {

	
		/**
		 * Login Module
		 */
		@Query(value = "SELECT * FROM patient WHERE email = :email AND password = :password", nativeQuery = true)
		public Patient login(@Param("email") String email, @Param("password") String password);

		@Query(value = "SELECT * FROM patient WHERE id = :ID", nativeQuery = true)
		public Patient findPatientById(@Param("ID") int id);
		
		@Query(value = "SELECT * FROM patient WHERE email = :email", nativeQuery = true)
		public Patient findPatientByEmail(@Param("email") String email);
		
	
		
		
}