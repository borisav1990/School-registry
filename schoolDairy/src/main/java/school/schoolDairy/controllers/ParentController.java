package school.schoolDairy.controllers;

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

import school.schoolDairy.models.Grade;
import school.schoolDairy.models.Learner;
import school.schoolDairy.models.OpenDoor;
import school.schoolDairy.models.SchoolSubject;
import school.schoolDairy.service.ParentService;

@RequestMapping("/parent")
@Controller
public class ParentController {
	
	
	@Autowired
	private ParentService parentService;
	
	@GetMapping("/home")
	public String defaultView() {
		return "parent_pages/post_page";
	}
	
	@GetMapping("/viewLearners")
	public String viewLearnersOfParent(Principal principal, Model model){
		List<Learner> listOfLearners = parentService.getAllLearnersOfParent(principal.getName());
		model.addAttribute("listOfLearners", listOfLearners);
		return "parent_pages/default_page";
	}
	
	@GetMapping("/viewGrade/{learnerId}")
	public String viewGrade(Model model, @PathVariable Long learnerId) {
		List<Grade> listOfGrades = parentService.getAllGradesOfLearner(learnerId);
		model.addAttribute("listOfGrades", listOfGrades);
		
		List<SchoolSubject> listOfSubject = parentService.getAllSubjectShcool();
		model.addAttribute("listOfSubject", listOfSubject);
		return "parent_pages/view_grade"; 
		
	}
	
	@GetMapping("/openDoor")
	public String requestForOpenDoor(Model model, Principal principal) {
		
		List<OpenDoor> listOfOpenDoor = parentService.getAllOpenDoor(principal.getName());
		model.addAttribute("listOfOpenDoor", listOfOpenDoor);
		
		
		model.addAttribute("opendoor", new OpenDoor());
		List<Learner> listOfLearners = parentService.getAllLearnersOfParent(principal.getName());
		model.addAttribute("listOfLearners", listOfLearners);
	
		
		
		
		return "parent_pages/opendoor_page";
	}	
		
	@PostMapping("/sendRequest")
	public String sendRequest(Model model, @ModelAttribute OpenDoor openDoor, RedirectAttributes redirectAttr) {
		if(openDoor.getId() == null && openDoor.getForLearner() != null && openDoor.getRequestDate()!= null && openDoor.getTime() != null) {
			 parentService.saveOpenDoor(openDoor);
			 redirectAttr.addFlashAttribute("sendSucces", "Успешно сте поднели захтев за отворена");
		     return "redirect:/parent/openDoor";
            }
		if(openDoor.getId() != null && openDoor.getForLearner() != null && openDoor.getRequestDate()!= null && openDoor.getTime() != null) {
			 parentService.saveOpenDoor(openDoor);
			 redirectAttr.addFlashAttribute("sendSucces", "Успешно сте променили за отворена");
		     return "redirect:/parent/openDoor";
			
		}
		
		
		redirectAttr.addFlashAttribute("errorSucces", "Грешка у уносу. Могућност да је неко поље остало празно");
		return "redirect:/parent/openDoor";
		
	}
	
	@GetMapping("/editOpenDoor/{openDoorId}")
	public String editOpenDoor(Model model, @PathVariable Long openDoorId, Principal principal ) {
		OpenDoor opendoor = parentService.getOpenDoorForEdit(openDoorId);
		model.addAttribute("opendoor", opendoor);
		
		List<Learner> listOfLearners = parentService.getAllLearnersOfParent(principal.getName());
		model.addAttribute("listOfLearners", listOfLearners);
		
		List<OpenDoor> listOfOpenDoor = parentService.getAllOpenDoor(principal.getName());
		model.addAttribute("listOfOpenDoor", listOfOpenDoor);
		
		model.addAttribute("isUpdate", true);
		
		return"parent_pages/opendoor_page";
		
	}
	
	
	@GetMapping(value="/parentChat")
	public String teacherChat() {
		return"parent_pages/chat_parent";
	}
	
	
	
		
	
	
	
	

}
