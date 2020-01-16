package school.schoolDairy.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import school.schoolDairy.models.Role;
public interface RoleRepository extends JpaRepository<Role, Integer> {
	

}
