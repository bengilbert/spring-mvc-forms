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

/**
 * Controller class thats responds to requests for the home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {

	private static final Logger LOG = Logger.getLogger(HomeController.class);
	private static List<Candidate> candidates;

	static {
		candidates = new ArrayList<Candidate>();

		Candidate candidate1 = new Candidate();
		candidate1.setDescription("First Candidate");
		candidate1.setName("candidate1");
		candidate1.setId(1L);
		candidates.add(candidate1);

		Candidate candidate2 = new Candidate();
		candidate2.setDescription("Second Candidate");
		candidate2.setName("candidate2");
		candidate2.setId(2L);
		candidates.add(candidate2);

		Candidate candidate3 = new Candidate();
		candidate3.setDescription("Third Candidate");
		candidate3.setName("candidate3");
		candidate3.setId(3L);
		candidates.add(candidate3);

	}

	@ModelAttribute("form")
	public Form getForm() {
		Form form = new Form();
		List<Candidate> candidates = new ArrayList<Candidate>();
		candidates.add(new Candidate());

		form.setCandidates(candidates);

		return form;
	}

	@ModelAttribute("candidates")
	public List<Candidate> getCandidates() {
		return candidates;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showHomePage() {
		return "index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onAddCandidate(Form form) {

		form.getCandidates().add(new Candidate());

		return "index";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Candidate.class, "id",
				new PropertyEditorSupport() {
					public String getAsText() {
						Candidate candidate = (Candidate) getValue();
						return "" + candidate.getId();
					}

					public void setAsText(String text) {

						Long requiredId = Long.valueOf(text);

						for (Candidate candidate : candidates) {
							if (candidate.getId().equals(requiredId)) {
								setValue(candidate);
								break;
							}
						}

					}
				});
	}

}
