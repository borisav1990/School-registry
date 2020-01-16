package school.schoolDairy.repository;




import org.springframework.data.repository.CrudRepository;


import school.schoolDairy.models.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
	/*@Query("SELECT f FROM Learner AS f WHERE f.teacher.id=?1 ")
	List<Learner> findAllById(Long teacherId);
*/
}
