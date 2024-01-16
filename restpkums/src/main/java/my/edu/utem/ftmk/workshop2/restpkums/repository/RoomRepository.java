package my.edu.utem.ftmk.workshop2.restpkums.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.workshop2.restpkums.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}