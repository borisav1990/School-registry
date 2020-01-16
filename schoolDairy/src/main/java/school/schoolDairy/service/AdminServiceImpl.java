package school.schoolDairy.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import school.schoolDairy.models.Day;
import school.schoolDairy.models.Learner;
import school.schoolDairy.models.OrdinalTime;
import school.schoolDairy.models.Role;
import school.schoolDairy.models.Schedule;
import school.schoolDairy.models.ScheduleField;
import school.schoolDairy.models.SchoolClass;
import school.schoolDairy.models.SchoolSubject;
import school.schoolDairy.models.User;
import school.schoolDairy.repository.DayRepository;
import school.schoolDairy.repository.LearnerRepository;
import school.schoolDairy.repository.OrdinalTimeRepository;
import school.schoolDairy.repository.RoleRepository;
import school.schoolDairy.repository.ScheduleFieldRepository;
import school.schoolDairy.repository.ScheduleRepository;
import school.schoolDairy.repository.SchoolClassRepository;
import school.schoolDairy.repository.SubjectRepository;
import school.schoolDairy.repository.UserRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private LearnerRepository learnerRepository;
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	private ScheduleFieldRepository scheduleFieldRepository;
	
	@Autowired 
	private DayRepository dayRepository;
	
	@Autowired
	private OrdinalTimeRepository timeRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private SchoolClassRepository classRepository;
	
	

	@Override
	public List<Role> getAllRole() {
		return roleRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		List<Role> listfromDB = roleRepository.findAll();
		List<Role> listForDB = new ArrayList<>();
		for (Role role : listfromDB) {
			if (role.getId() == user.getInputRole()) {
				listForDB.add(role);
				}
			}
		
		String passwordEncrypt = passwordEncoder.encode(user.getPassword());
		user.setPassword(passwordEncrypt);
		user.setRoles(listForDB);
        userRepository.save(user);
		}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void deleteUser(Integer userId) {
		 userRepository.deleteById(userId);
		
	}

	@Override
	public User getOneUserForEdit(Integer userId) {
		return userRepository.findById(userId).get();
		}

	@Override
	public List<User> fetchAllTeacher() {
		return (List<User>) userRepository.fetchAllTeacher();		
		
		//return userRepository.fetchAllTeacher();
	}

	@Override
	public List<User> fetchAllParent() {
		return (List<User>)userRepository.fetchAllParent();
	}

	@Override
	public void saveLearner(Learner learner) {
		learnerRepository.save(learner);
		
		
	}

	@Override
	public List<Learner> fetchAllLearner() {
		 return (List<Learner>) learnerRepository.findAll();
		
	}

	@Override
	public Learner getOneLearnerForEdit(Long learnerId) {
		return learnerRepository.findById(learnerId).get();
		
	}

	@Override
	public void deleteLearner(Long learnerId) {
		learnerRepository.deleteById(learnerId);
		
	}

	@Override
	public List<Schedule> getAllSchedule() {
		return (List<Schedule>) scheduleRepository.findAll();
	}

	@Override
	public List<ScheduleField> getAllScheduleFieldBySchedule(Long scheduleId) {
		return scheduleFieldRepository.findAllById(scheduleId);
		
	}

	@Override
	public List<Day> getAllDay() {
	     return (List<Day>) dayRepository.findAll(); 
	}

	@Override
	public List<OrdinalTime> getAllTime() {
		return (List<OrdinalTime>) timeRepository.findAll();
	}

	@Override
	public List<SchoolSubject> getAllSubject() {
		return (List<SchoolSubject>) subjectRepository.findAll();
	}

	@Override
	public void saveScheduleField(ScheduleField scheduleField) {
		scheduleFieldRepository.save(scheduleField);
		
	}

	@Override
	public void deleteSubjectFromScheduleField(Long fieldId) {
		scheduleFieldRepository.deleteById(fieldId);
		
	}

	@Override
	public List<SchoolClass> getAllSchoolClass() {
		return (List<SchoolClass>) classRepository.findAll();
	}

	@Override
	public void saveSchedule(Schedule schedule) {
		scheduleRepository.save(schedule);
		
	}
	
	
	
	
	}
