package school.schoolDairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import school.schoolDairy.models.OpenDoor;

public interface OpenDoorRepository extends JpaRepository<OpenDoor, Long> {
     
	@Query("SELECT f FROM OpenDoor AS f WHERE f.forLearner.userParent.email=?1")
	List<OpenDoor> getAllOpenDoor(String name);
    
	@Query("SELECT f FROM OpenDoor AS f WHERE f.forLearner.user.email=?1")
	List<OpenDoor> getAllOpenDoorByTeacher(String name);
	
	

}
