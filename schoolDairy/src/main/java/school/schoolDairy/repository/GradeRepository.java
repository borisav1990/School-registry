package school.schoolDairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import school.schoolDairy.models.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {
	
	@Query("SELECT f FROM Grade AS f WHERE f.idOfLerner.id=?1 ")
	List<Grade> findAllGradesOfLearner(Long learnerId);
	
	@Query("SELECT f FROM Grade AS f WHERE f.idOfLerner.schoolClass.id=?1")
	List<Grade> getAverage(Long classId);
	
}
