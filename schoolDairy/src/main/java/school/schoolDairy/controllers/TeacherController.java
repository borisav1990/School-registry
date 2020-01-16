package school.schoolDairy.controllers;


import java.security.Principal;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import school.schoolDairy.service.TeacherService;
import school.schoolDairy.models.Grade;
import school.schoolDairy.models.Learner;
import school.schoolDairy.models.OpenDoor;
import school.schoolDairy.models.SchoolSubject;
import school.schoolDairy.models.Teacher;


@RequestMapping("/teachers")
@Controller
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	//--------------------------------
	
	@GetMapping(value="/home")
	public String teacherIndex(Model model,Principal principal) {
		model.addAttribute("connUser", principal.getName());
		return"teachers_pages/indexTeacher";
	}
	
	//--------------------------------
	
	@GetMapping(value="/teacherChat")
	public String teacherChat(Model model,Principal principal) {
		model.addAttribute("connUser", principal.getName());
		return"teachers_pages/chatTeacher";
	}
	
	//---------------------------------------
	
	@GetMapping(value="/viewLearners")
	public String viewLearners(Model model,  Principal principal) {
		List<Teacher> listOfTeachers = teacherService.getAllTeachers();
		model.addAttribute("listOfTeachers", listOfTeachers);
		List<Learner> listOfLearner = teacherService.getLearnersByUserName(principal.getName());
		model.addAttribute("listOfLearners", listOfLearner);
		model.addAttribute("objOfGrade", new Grade());
		List<SchoolSubject> listOfSubject = teacherService.getAllSubjectShcool();
		model.addAttribute("listOfSubject", listOfSubject);
		model.addAttribute("connUser", principal.getName());
		return "teachers_pages/viewLearners";
	}
	
	//----------------------------------------
	
	@GetMapping(value="/viewGrade/{learnerId}")
	public String viewGrade(Model model, @PathVariable Long learnerId, Principal principal){
		List<Grade> listOfGrades = teacherService.getAllGradesOfLearner(learnerId);
		model.addAttribute("listOfGrades", listOfGrades);
		List<SchoolSubject> listOfSubject = teacherService.getAllSubjectShcool();
		model.addAttribute("listOfSubject", listOfSubject);
		model.addAttribute("objOfGrade", new Grade());
		model.addAttribute("connUser", principal.getName());
		return "teachers_pages/viewGrades";
		
	}
	
	//------------------------------------------
	
	@PostMapping(value="/saveOrUpdateGrade")
	public String saveGrade(Model model, @ModelAttribute Grade grade,  RedirectAttributes redirectAttr) {
		
		if ((grade.getId()!= null) && (grade.getHeightGrade() != 0)) {
			  if (grade.getHeightGrade() > 0 && grade.getHeightGrade() <= 5) {
				    Grade forDate = teacherService.getGradeByid(grade.getId());
				    grade.setCreatedDate(forDate.getCreatedDate());
				    grade.setUpdatedDate(new Date());			
					teacherService.saveGrade(grade);
					redirectAttr.addFlashAttribute("messageSuccessUpdate", "Ученику " + grade.getIdOfLerner().getFirstName() + " " + grade.getIdOfLerner().getLastname() + " из предмета " + grade.getSchoolSubject().getSubjectName() + " успешно промењена оцена на " + grade.getHeightGrade());
					return  "redirect:/teachers/viewGrade/" + grade.getIdOfLerner().getId(); 
				  }else {
					 redirectAttr.addFlashAttribute("errorData", "Погрешан унос");
				     return  "redirect:/teachers/viewGrade/" + grade.getIdOfLerner().getId();
				  }
			  }
		if(grade.getHeightGrade() != 0 ){
			if(grade.getHeightGrade() > 0 && grade.getHeightGrade() <= 5 && grade.getSchoolSubject() != null) {
				grade.setCreatedDate(new Date());
				teacherService.saveGrade(grade);
				redirectAttr.addFlashAttribute("messageSuccessCreate", "Ученику " + grade.getIdOfLerner().getFirstName() + " " + grade.getIdOfLerner().getLastname() + " из предмета " + grade.getSchoolSubject().getSubjectName() + " успешно уписана оцена " + grade.getHeightGrade());
				return  "redirect:/teachers/viewLearners"; 
				}else {
			    redirectAttr.addFlashAttribute("errorData", "Погрешан унос. Дозвољен упис оцене је у опсегу од 1 до 5 или нисте изабрали предмет.");
		        return  "redirect:/teachers/viewLearners";
		}
			}else {
				redirectAttr.addFlashAttribute("errorNull", "Нисте унели вредност оцене у поља и нисте изабрали предмет.");
				 return  "redirect:/teachers/viewLearners";
				}
		}
	
	//-------------------------------------------------------------
	
	@GetMapping(value="/deleteGrade")
	    public String deleteCountry(Long id, String learner, RedirectAttributes redirectAttr) {
		 boolean delSuccess = teacherService.deleteById(id);
		 if(delSuccess) {
			 redirectAttr.addFlashAttribute("delSuccess", "Оцена успешно обрисана!");
			 return"redirect:/teachers/viewGrade/"+learner;
         }else  {
        	 redirectAttr.addFlashAttribute("delError", "Оцена није обрисана покушајте поново!");
        	 return"redirect:/teachers/viewGrade/"+learner;
        	 }	
	    }
	
	//-----------------------------------------------------------
	
	@GetMapping("/openDoor")
	public String viewRequestForOpenDoor(Model model, Principal principal) {
		List<OpenDoor> listOfOpenDoor = teacherService.getAllOpenDoorByTeacher(principal.getName());
		model.addAttribute("listOfOpenDoor", listOfOpenDoor);
		model.addAttribute("connUser", principal.getName());
		return "teachers_pages/openDoor";
	}
	
	//-----------------------------------------------------------
	
	@GetMapping("/acceptOpenDoor/{doorId}")
	public String acceptOpenDoor(@PathVariable Long doorId, RedirectAttributes redirectAttr) {
		OpenDoor openDoor = teacherService.getOpenDoorForResponse(doorId);
		openDoor.setAcceptOrnot(true);
		teacherService.saveResponse(openDoor);
		redirectAttr.addFlashAttribute("acceptDoor", "Захтев успешно прихваћен");
		
		return "redirect:/teachers/openDoor";
	}
	
	//--------------------------------------------------------
	
	@GetMapping("/declineOpenDoor/{doorId}")
	public String declineOpenDoor(@PathVariable Long doorId, RedirectAttributes redirectAttr) {
		OpenDoor openDoor = teacherService.getOpenDoorForResponse(doorId);
		openDoor.setAcceptOrnot(false);
		teacherService.saveResponse(openDoor);
		redirectAttr.addFlashAttribute("declineDoor", "Захтев одбијен");
		return "redirect:/teachers/openDoor";
	}
	
	//---------------------------------------------------------------
	
	
	
	
	
	
}
