package school.schoolDairy.repository;

import org.springframework.data.repository.CrudRepository;

import school.schoolDairy.models.SchoolSubject;

public interface SubjectRepository extends CrudRepository<SchoolSubject, Long> {

}
