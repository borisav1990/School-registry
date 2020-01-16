package school.schoolDairy.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import school.schoolDairy.models.Grade;
import school.schoolDairy.models.Learner;
import school.schoolDairy.models.OpenDoor;
import school.schoolDairy.models.SchoolSubject;
import school.schoolDairy.models.Teacher;
import school.schoolDairy.repository.GradeRepository;
import school.schoolDairy.repository.LearnerRepository;
import school.schoolDairy.repository.OpenDoorRepository;
import school.schoolDairy.repository.SubjectRepository;
import school.schoolDairy.repository.TeacherRepository;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private LearnerRepository learnerRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private OpenDoorRepository doorRepository;
	

	@Override
	public List<Teacher> getAllTeachers() {
		return (List<Teacher>) teacherRepository.findAll();
	}

	@Override
	public List<Learner> getAllLearners() {
		return (List<Learner>) learnerRepository.findAll();
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
	public Grade getGradeByid(Long id) {
		
		return gradeRepository.getOne(id);
		
		
	}

	@Override
	public Grade saveGrade(Grade grade) {
		
		return gradeRepository.save(grade);
		
		
	}

	@Override
	public boolean deleteById(Long id) {
		gradeRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Learner> getLearnersByUserName(String name) {
		return learnerRepository.getLearnersByUserName(name);
		
	}

	@Override
	public List<OpenDoor> getAllOpenDoorByTeacher(String name) {
		
		return doorRepository.getAllOpenDoorByTeacher(name);
	}

	@Override
	public OpenDoor getOpenDoorForResponse(Long doorId) {
		
		return doorRepository.getOne(doorId);
	}

	@Override
	public void saveResponse(OpenDoor openDoor) {
		doorRepository.save(openDoor);
		
	}

	

	
	
	

}
