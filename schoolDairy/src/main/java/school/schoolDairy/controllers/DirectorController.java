package school.schoolDairy.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import school.schoolDairy.models.SchoolClass;
import school.schoolDairy.service.DirectorService;


@Controller
@RequestMapping("/director")
public class DirectorController {
	
	@Autowired
	private DirectorService directorService;
	
	//----------------------------------------------------------
	
	@RequestMapping("/home")
	public String adminView(Model model, Principal principal) {
		List<SchoolClass> listOfClass = directorService.getAllSchoolClass();
		model.addAttribute("listOfClass", listOfClass);
		model.addAttribute("connUser", principal.getName());
		return "director_pages/director_page";
    }
	
	//-----------------------------------------------------------
	
	@GetMapping("/displayGrade/{classId}")
	public String barGraph(Model model, @PathVariable Long classId, Principal principal) {
		Map<String, Double> surveyMap = directorService.getAverageGrade(classId);
		SchoolClass schoolClass = directorService.getSchoolClass(classId);
		model.addAttribute("schoolClass", schoolClass);
	    model.addAttribute("surveyMap", surveyMap);
	    model.addAttribute("connUser", principal.getName());
	    return "director_pages/graph_grade_page";
	}
	
	//----------------------------------------------------------
	
	@GetMapping("/averageOfSchool")
	public String averageOfSchool(Model model, Principal principal) {
		Map<String, Double> surveyMap = directorService.getAverageOfSchool();
	    model.addAttribute("surveyMap", surveyMap);
	    model.addAttribute("connUser", principal.getName());
		return "director_pages/graph_average_page";
	}
	
	//---------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	

}
