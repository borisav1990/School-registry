package school.schoolDairy.service;

import java.util.List;

import school.schoolDairy.models.Grade;
import school.schoolDairy.models.Learner;
import school.schoolDairy.models.OpenDoor;
import school.schoolDairy.models.SchoolSubject;

public interface ParentService {

	List<Learner> getAllLearnersOfParent(String name);

	List<Grade> getAllGradesOfLearner(Long learnerId);

	List<SchoolSubject> getAllSubjectShcool();

	void saveOpenDoor(OpenDoor openDoor);

	List<OpenDoor> getAllOpenDoor(String name);

	OpenDoor getOpenDoorForEdit(Long openDoorId);

}
