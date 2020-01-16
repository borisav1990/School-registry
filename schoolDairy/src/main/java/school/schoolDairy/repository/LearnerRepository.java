package school.schoolDairy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import school.schoolDairy.models.Learner;


public interface LearnerRepository extends CrudRepository<Learner, Long> {

	
	@Query("SELECT f FROM Learner AS f WHERE f.user.email=?1 ")
	List<Learner> getLearnersByUserName(String name);
    
	
	
	@Query("SELECT f FROM Learner AS f WHERE f.userParent.email=?1 ")
	List<Learner> getAllLearnersOfParent(String name);

	
       
}
