package interfaces;

import java.util.Date;
import java.util.EnumSet;
import java.util.List;

import javax.ejb.Local;

import entities.Competence;
import entities.DayOff;
import entities.Resource;
import entities.Term;
import enums.Availability;

@Local
public interface MandatServiceLocal {
	public List<Resource> findResourceByCompetenceAndAvailability(Competence competence,
			EnumSet<Availability> availables);

	public void addTerm(Term term);

	public Term calculateEndDateTerm(Term term);

	public String testerDateDeb(Resource resource, Term term);

	public float fraisMandat(Term term);
	
	public void alerteMandat();

}
