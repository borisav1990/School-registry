package school.schoolDairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import school.schoolDairy.models.ScheduleField;

public interface ScheduleFieldRepository extends CrudRepository<ScheduleField, Long> {
	
	
	@Query("SELECT f FROM ScheduleField AS f WHERE f.schedule.id=?1 ")
	List<ScheduleField> findAllById(Long scheduleId);



}
