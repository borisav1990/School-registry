package school.schoolDairy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import school.schoolDairy.models.Grade;
import school.schoolDairy.models.Learner;
import school.schoolDairy.models.OpenDoor;
import school.schoolDairy.models.SchoolSubject;
import school.schoolDairy.repository.GradeRepository;
import school.schoolDairy.repository.LearnerRepository;
import school.schoolDairy.repository.OpenDoorRepository;
import school.schoolDairy.repository.SubjectRepository;

@Service
@Transactional
public class ParentServiceImpl implements ParentService {
	
	@Autowired 
	private LearnerRepository learnerRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private OpenDoorRepository openDoorRepository;
	

	@Override
	public List<Learner> getAllLearnersOfParent(String name) {
		return learnerRepository.getAllLearnersOfParent(name);
	}


	@Override
	public List<Grade> getAllGradesOfLearner(Long learnerId) {
		return gradeRepository.findAllGradesOfLearner(learnerId);
	}


	@Override
	public List<SchoolSubject> getAllSubjectShcool() {
		return (List<SchoolSubject>) subjectRepository.findAll();
	}


	@Override
	public void saveOpenDoor(OpenDoor openDoor) {
		openDoor.setCreatedDate(new Date());
		openDoorRepository.save(openDoor);
		
	}


	@Override
	public List<OpenDoor> getAllOpenDoor(String name) {
		
		return openDoorRepository.getAllOpenDoor(name) ;
	}


	@Override
	public OpenDoor getOpenDoorForEdit(Long openDoorId) {
		return openDoorRepository.findById(openDoorId).get();
		
	}

	
}
