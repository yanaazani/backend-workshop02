package my.edu.utem.ftmk.workshop2.restpkums.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import my.edu.utem.ftmk.workshop2.restpkums.model.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	@Query(value="SELECT * FROM appointment "
			+ " WHERE id = :id",
			nativeQuery = true)
	public Appointment findByAppointmentId(@Param("id")int appointment);

	/**
	 * This method is for retrieving appointment list on a certain time
	 * @param appointDate
	 * @param appointTime
	 * @return
	 */
	@Query(value = "SELECT * FROM appointment "
			+ " WHERE bookingdate = :date "
			+ " AND bookingtime = :time ", nativeQuery=true)
	public List<Appointment> getAppointmentListbyCertainTime(
			@Param("date")String appointDate, @Param("time")String appointTime); 
	
	@Query(value="SELECT * FROM appointment "
	        + " WHERE status = :status "
	        + " AND patientId = :patientId",
	        nativeQuery = true)
	public List<Appointment> getByAppointmentStatusId(@Param("status") String appointStatus,@Param("patientId") int userId);
	
	@Query(value="SELECT * FROM appointment "
			+ " WHERE id = :validateId"
	        + " AND bookingdate = :validatebookingdate "
	        + " AND bookingtime = :validatebookingtime "
	        + " AND status = :validatestatus "
	        + " AND patientId = :validatepatientId", nativeQuery = true)
	public List<Appointment> validateAppointment(@Param("validateId")int validateId,@Param("validatebookingdate")String validateDate, 
			@Param("validatebookingtime")String validateTime, @Param("validatestatus") String validateStatus, 
			@Param("validatepatientId") int validatepatientId);


	 @Modifying
	    @Query(value = "UPDATE appointment SET serviceRate = :serviceRate WHERE id = :id", nativeQuery = true)
	    void updateServiceRateById(@Param("id") int id, @Param("serviceRate") int serviceRate);
	


}