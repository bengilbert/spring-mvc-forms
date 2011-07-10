package demo;

import java.util.List;

import org.apache.log4j.Logger;

public class Form {

	private static final Logger LOG = Logger.getLogger(Form.class);
	
	List<Candidate> candidates = null;// new ArrayList<Candidate>();

	public Form() {
		/* empty */
		LOG.debug("create Form");
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

}
