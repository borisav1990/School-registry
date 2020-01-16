package school.schoolDairy.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import school.schoolDairy.models.SchoolClass;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {

}
