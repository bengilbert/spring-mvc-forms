package demo;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterController {
	private static final Logger LOG = Logger.getLogger(RegisterController.class);
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String onGet(@ModelAttribute("alternativeName") RegisterForm form) {
		
		return "registerNewUser";
	}	
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("alternativeName") RegisterForm form, Model model) {
		model.addAttribute("name", form.getName());
		
		return "userRegistered";
	}
}
