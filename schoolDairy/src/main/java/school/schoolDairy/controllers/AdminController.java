package school.schoolDairy.controllers;
import school.schoolDairy.models.Day;
import school.schoolDairy.models.Learner;
import school.schoolDairy.models.OrdinalTime;
import school.schoolDairy.models.Role;
import school.schoolDairy.models.Schedule;
import school.schoolDairy.models.ScheduleField;
import school.schoolDairy.models.SchoolClass;
import school.schoolDairy.models.SchoolSubject;
import school.schoolDairy.models.User;
import school.schoolDairy.service.AdminService;

import java.security.Principal;
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

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	public static Long schedule = null;
	
	//---------------------------------------------------------
	
	@RequestMapping("/home")
	public String adminView(Model model, Principal principal) {
		model.addAttribute("connUser", principal.getName());
		return "administrator_pages/admin_page";
	}
	
	//---------------------------------------------------------
	
	@RequestMapping("/addUser")
	public String addUsers(Model model,Principal principal ) {
		List<Role> listOfRole = adminService.getAllRole();
		model.addAttribute("listOfRole", listOfRole);
		model.addAttribute("objOfUser", new User());
		List<User> listOfUser = adminService.getAllUsers();
		model.addAttribute("listOfUser", listOfUser);
		model.addAttribute("connUser", principal.getName());
		return "administrator_pages/add_user_page";
		}
	
	//---------------------------------------------------------
	
	@PostMapping ("/saveUser")
	public String saveUser(@ModelAttribute User user, RedirectAttributes redirectAttr) {
		if(user.getId()== null && user.getFirstName()!="" && user.getLastName()!="" && user.getEmail()!="" && user.getPassword()!="" && user.getInputRole() != 0) {
			adminService.saveUser(user);
			redirectAttr.addFlashAttribute("saveSucces", "Корисник успешно сачуван.");
			return "redirect:/admin/addUser";
			}
		if (user.getId()!= null && user.getFirstName()!=null && user.getLastName()!= null && user.getEmail()!=null && !user.getPassword().contains("$") && user.getInputRole()!=0) {
			adminService.saveUser(user);
			redirectAttr.addFlashAttribute("saveSucces", "Корисник успешно ажуриран.");
			return "redirect:/admin/addUser";
		}
		
		redirectAttr.addFlashAttribute("saveError", "Дошло је до грешке. Вероватно су нека поља остала празна или није улога одабрана или лозинка није унесена.");
		return "redirect:/admin/addUser";
	}
	
	//-----------------------------------------------------------
	
	@GetMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable Integer userId, RedirectAttributes redirectAttr) {
		adminService.deleteUser(userId);
		redirectAttr.addFlashAttribute("deleteSucces", "Kорисник успешно обрисан.");
		return"redirect:/admin/addUser";
		}
	
	//--------------------------------------------------------
	
	@GetMapping("/editUser/{userId}")
	public String editUser(Model model, @PathVariable Integer userId, Principal principal) {
		User user = adminService.getOneUserForEdit(userId);
		model.addAttribute("objOfUser", user);
		List<Role> listOfRole = adminService.getAllRole();
		model.addAttribute("listOfRole", listOfRole);
		List<User> listOfUser = adminService.getAllUsers();
		model.addAttribute("listOfUser", listOfUser);
		model.addAttribute("isUpdate", true);
		model.addAttribute("connUser", principal.getName());
		return"administrator_pages/add_user_page";
		}
	
	//-----------------------------------------------------------
	
	@GetMapping("/addLearner")
	public String addUser(Model model, Principal principal) {
		model.addAttribute("objOfLearner",new Learner());
		List<Learner> listOfLearner = adminService.fetchAllLearner();
		model.addAttribute("listOfLearner", listOfLearner);
		List<User> listOfTeacher =  adminService.fetchAllTeacher();
		model.addAttribute("listOfTeacher", listOfTeacher);
		List<User> listOfParent = adminService.fetchAllParent();
		model.addAttribute("listOfParent", listOfParent);
		model.addAttribute("connUser", principal.getName());
		return"administrator_pages/add_learner_page";
		}
	
	//----------------------------------------------------------
	
	@PostMapping ("/saveLearner")
	public String saveUser(@ModelAttribute Learner learner, RedirectAttributes redirectAttr) {
		if(learner.getId()== null && learner.getFirstName()!="" && learner.getLastname()!="" && learner.getLevel()!=0 && learner.getDepartment()!= 0 && learner.getUser()!= null && learner.getUserParent()!=null) {
			adminService.saveLearner(learner);
			redirectAttr.addFlashAttribute("saveSucces", "Ученик успешно сачуван.");
			return "redirect:/admin/addLearner";
			}
		if (learner.getId()!= null && learner.getFirstName()!="" && learner.getLastname()!="" && learner.getLevel()!=0 && learner.getDepartment()!= 0 && learner.getUser()!= null && learner.getUserParent()!=null) {
			adminService.saveLearner(learner);
			redirectAttr.addFlashAttribute("saveSucces", "Ученик успешно ажуриран.");
			return "redirect:/admin/addLearner";
		}
		
		redirectAttr.addFlashAttribute("saveError", "Дошло је до грешке. Вероватно су нека поља остала празна или није улога одабрана или лозинка није унесена.");
		return "redirect:/admin/addLearner";
		}
	
	//-------------------------------------------------------------
	
	@GetMapping("/editLearner/{learnerId}")
	public String editLearner(Model model, @PathVariable Long learnerId, Principal principal) {
		Learner learner = adminService.getOneLearnerForEdit(learnerId);
		model.addAttribute("objOfLearner", learner);
		List<User> listOfTeacher =  adminService.fetchAllTeacher();
		model.addAttribute("listOfTeacher", listOfTeacher);
		List<User> listOfParent = adminService.fetchAllParent();
		model.addAttribute("listOfParent", listOfParent);
		List<Learner> listOfLearner = adminService.fetchAllLearner();
		model.addAttribute("listOfLearner", listOfLearner);
		model.addAttribute("isUpdate", true);
		return"administrator_pages/add_learner_page";
		}
	
	//----------------------------------------------------------------
	
	@GetMapping("/deleteLearner/{learnerId}")
	public String deleteLearner(@PathVariable Long learnerId, RedirectAttributes redirectAttr) {
		adminService.deleteLearner(learnerId);
		redirectAttr.addFlashAttribute("deleteSucces", "Ученик је успешно обрисан.");
		return"redirect:/admin/addLearner";
		}
	
	//---------------------------------------------------------------
	
	@GetMapping("/viewSchedule")
	public String viewSchedule(Model model, Principal principal)  {
		List<User> listOfTeacher =  adminService.fetchAllTeacher();
		model.addAttribute("listOfTeacher", listOfTeacher);
		List<SchoolClass> listOfSchoolClass = adminService.getAllSchoolClass();
		model.addAttribute("listOfSchoolClass", listOfSchoolClass);
		List<Schedule> listOfSchedule = adminService.getAllSchedule();
		model.addAttribute("listOfSchedule", listOfSchedule);
		model.addAttribute("scheduleObj", new Schedule());
		model.addAttribute("connUser", principal.getName());
		return"administrator_pages/view_schedule_page";
		}
	
	//--------------------------------------------------------------
	
	@GetMapping("/editSheduleField/{scheduleId}")
	public String editSheduleField(Model model, @PathVariable Long scheduleId, Principal principal) {
		schedule  = scheduleId;
		List<ScheduleField> listOfField = adminService.getAllScheduleFieldBySchedule(scheduleId);
		model.addAttribute("listOfField", listOfField);
		model.addAttribute("objOfScheduleField", new ScheduleField());
		List<Day> listOfDay = adminService.getAllDay();
		model.addAttribute("listOfDay", listOfDay);
		List<OrdinalTime> listOfTime = adminService.getAllTime();
		model.addAttribute("listOfTime", listOfTime);
		List<SchoolSubject> listOfSubject = adminService.getAllSubject();
		model.addAttribute("listOfSubject", listOfSubject);
		model.addAttribute("idOfSchedule" , schedule);
		model.addAttribute("connUser", principal.getName());
		return"administrator_pages/edit_schedule_field";
	}
	
	//---------------------------------------------------------------
	
	@PostMapping("/saveScheduleField")
	public String saveScheduleField(@ModelAttribute ScheduleField scheduleField, RedirectAttributes redirectAttr ) {
		if(scheduleField.getId() == null && scheduleField.getSubject()!= null && scheduleField.getTime() != null && scheduleField.getDay() != null) {
			redirectAttr.addFlashAttribute("saveSucces", "Предмет успешно постављен у распоред.");
			adminService.saveScheduleField(scheduleField);
			return "redirect:/admin/editSheduleField/" + schedule;
			}
		else {
			redirectAttr.addFlashAttribute("saveError", "Неуспешно нека поља су празна.");
			return "redirect:/admin/editSheduleField/" + schedule;
			}
		}
	
	//-----------------------------------------------------------------
	
	@GetMapping("/deleteSubjectFromField/{fieldId}")
	public String deleteSubjectFromField(@PathVariable Long fieldId, RedirectAttributes redirectAttr) {
		adminService.deleteSubjectFromScheduleField(fieldId);
		redirectAttr.addFlashAttribute("deleteSucces", "Предмет успешно уклоњен из поља.");
		return "redirect:/admin/editSheduleField/" + schedule;
		}
	
	//------------------------------------------------------------------
	
	@PostMapping("/saveSchedule")
	public String saveSchedule(@ModelAttribute Schedule schedule, RedirectAttributes redirectAttr ) {
		if(schedule.getId() == null && schedule.getSchoolClass() != null && schedule.getUserTeacher()!= null ) {
			redirectAttr.addFlashAttribute("saveSucces", "Распоред успешно креиран.");
			adminService.saveSchedule(schedule);
			return "redirect:/admin/viewSchedule";
			}
		else{
			redirectAttr.addFlashAttribute("saveError", "Неуспешно, нека поља су остала празна.");
			return "redirect:/admin/viewSchedule";
			}
		}
	
	//----------------------------------------------------------------
	
}
