package school.schoolDairy.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import school.schoolDairy.models.Grade;
import school.schoolDairy.models.SchoolClass;
import school.schoolDairy.models.SchoolSubject;
import school.schoolDairy.repository.GradeRepository;
import school.schoolDairy.repository.SchoolClassRepository;
import school.schoolDairy.repository.SubjectRepository;

@Service
@Transactional
public class DirectorServiceImpl implements DirectorService{
	
	
	@Autowired
	private SchoolClassRepository classRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
    private SubjectRepository subjectRepository;

	
	public List<SchoolClass> getAllSchoolClass() {
		return (List<SchoolClass>) classRepository.findAll();
	}


	


	@Override
	public Map<String, Double> getAverageGrade(Long classId) {
		Map<String, Double> surveyMap = new LinkedHashMap<>();
		List<SchoolSubject> listSubject  = (List<SchoolSubject>) subjectRepository.findAll();
		List <Grade> listGrade = gradeRepository.getAverage(classId);
		double numberField = 0;
		double average = 0;
		double sume = 0;
		for (SchoolSubject subject : listSubject) {
			for (Grade grade : listGrade) {
				if(subject.getId() == grade.getSchoolSubject().getId()) {
					numberField ++;
					sume = sume + grade.getHeightGrade();  
				}
				
			}
		average = sume/numberField;
		surveyMap.put(subject.getSubjectName(), average);
		numberField = 0;
		sume=0;
		average=0;
		}
		return surveyMap;
	}
    
	@Override
	public Map<String, Double> getAverageOfSchool() {
		Map<String, Double> surveyMap = new LinkedHashMap<>();
		List<SchoolSubject> listSubject  = (List<SchoolSubject>) subjectRepository.findAll();
		List <Grade> listGrade = (List<Grade>) gradeRepository.findAll();
		double numberField = 0;
		double average = 0;
		double sume = 0;
		for (SchoolSubject subject : listSubject) {
			for (Grade grade : listGrade) {
				if(subject.getId() == grade.getSchoolSubject().getId()) {
					numberField ++;
					sume = sume + grade.getHeightGrade();  
				}
				
			}
		average = sume/numberField;
		surveyMap.put(subject.getSubjectName(), average);
		numberField = 0;
		sume=0;
		average=0;
		}
		return surveyMap;
		}

    
	@Override
	public SchoolClass getSchoolClass(Long classId) {
		return classRepository.getOne(classId);
	}
	
	
	

}
