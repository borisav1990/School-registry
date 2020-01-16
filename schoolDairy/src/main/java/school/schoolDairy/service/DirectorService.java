package school.schoolDairy.service;

import java.util.List;
import java.util.Map;


import school.schoolDairy.models.SchoolClass;

public interface DirectorService {

	List<SchoolClass> getAllSchoolClass();

	Map<String, Double> getAverageGrade(Long classId);

	Map<String, Double> getAverageOfSchool();

	SchoolClass getSchoolClass(Long classId);

	

}
