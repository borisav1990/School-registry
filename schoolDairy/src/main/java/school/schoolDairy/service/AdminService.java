package school.schoolDairy.service;

import java.util.List;

import school.schoolDairy.models.Day;
import school.schoolDairy.models.Learner;
import school.schoolDairy.models.OrdinalTime;
import school.schoolDairy.models.Role;
import school.schoolDairy.models.Schedule;
import school.schoolDairy.models.ScheduleField;
import school.schoolDairy.models.SchoolClass;
import school.schoolDairy.models.SchoolSubject;
import school.schoolDairy.models.User;

public interface AdminService {

	List<Role> getAllRole();

	void saveUser(User user);

	List<User> getAllUsers();

	void deleteUser(Integer userId);

	User getOneUserForEdit(Integer userId);

	List<User> fetchAllTeacher();

	List<User> fetchAllParent();

	void saveLearner(Learner learner);

	List<Learner> fetchAllLearner();

	Learner getOneLearnerForEdit(Long learnerId);

	void deleteLearner(Long learnerId);

	List<Schedule> getAllSchedule();

	List<ScheduleField> getAllScheduleFieldBySchedule(Long scheduleId);

	List<Day> getAllDay();

	List<OrdinalTime> getAllTime();

	List<SchoolSubject> getAllSubject();

	void saveScheduleField(ScheduleField scheduleField);

	void deleteSubjectFromScheduleField(Long fieldId);

	List<SchoolClass> getAllSchoolClass();

	void saveSchedule(Schedule schedule);

}
