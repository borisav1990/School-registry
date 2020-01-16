package school.schoolDairy.service;

import java.util.List;

import school.schoolDairy.models.Grade;
import school.schoolDairy.models.Learner;
import school.schoolDairy.models.OpenDoor;
import school.schoolDairy.models.SchoolSubject;
import school.schoolDairy.models.Teacher;


public interface TeacherService {

	//List<Learner> getAllLearnerByTeacher(Long teacherId);

	List<Teacher> getAllTeachers();

	List<Learner> getAllLearners();

	List<Grade> getAllGradesOfLearner(Long learnerId);

	List<SchoolSubject> getAllSubjectShcool();

	Grade getGradeByid(Long id);

	Grade saveGrade(Grade grade);

    boolean deleteById(Long id);

	List<Learner> getLearnersByUserName(String name);

	List<OpenDoor> getAllOpenDoorByTeacher(String name);

	OpenDoor getOpenDoorForResponse(Long doorId);

	void saveResponse(OpenDoor openDoor);

	

}
