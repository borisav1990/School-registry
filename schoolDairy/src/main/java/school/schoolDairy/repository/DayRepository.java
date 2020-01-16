package school.schoolDairy.repository;

import org.springframework.data.repository.CrudRepository;

import school.schoolDairy.models.Day;

public interface DayRepository extends CrudRepository<Day, Long> {

}
