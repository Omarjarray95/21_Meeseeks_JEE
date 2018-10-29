package utils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entities.Competence;
import entities.PkTerm;
import entities.Resource;
import entities.Term;
import enums.Availability;
import interfaces.ArchiveServiceLocal;
import interfaces.MandatServiceLocal;

@Startup
@Singleton
public class TestEJB {
	// @EJB
	// private MandatServiceLocal mondatServiceLocal;
	@EJB
	private ArchiveServiceLocal archiveServiceLocal;

	public TestEJB() {
		System.out.println(
				"************************************* construct***********************************************");
	}

	@PostConstruct
	public void init() {

		// System.out.println(
		// "*************************************post
		// construct***********************************************");
		//
		// System.out.println("************************************************************************************");
		// Competence competence = new Competence();
		// competence.setIdCompetence(1);
		// List<Resource> list =
		// mondatServiceLocal.findResourceByCompetenceAndAvailability(competence,
		// EnumSet.of(Availability.Available, Availability.AvailableSoon));
		// System.out.println("***********************" + list.size());
		//
		//

		// Term term = new Term();
		// Calendar cal =Calendar.getInstance();
		// cal.set(Calendar.DAY_OF_MONTH, 26);
		// cal.set(Calendar.MONTH,Calendar.OCTOBER);
		// cal.set(Calendar.YEAR,2018);
		//
		// term.setDateStart(cal.getTime());
		// term.setNumberofDaysTerm(20);
		// Resource resource= new Resource();
		// resource.setIdUser(1);
		// term.setResources(resource);
		// mondatServiceLocal.calculateEndDateTerm(term);
		System.out.println(
				"************************************* Archiiiive***********************************************");
		Term term = new Term();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 26);
		cal.set(Calendar.MONTH, Calendar.OCTOBER);
		cal.set(Calendar.YEAR, 2018);
		term.setDateEnd(cal.getTime());
		Resource resource = new Resource();
		resource.setIdUser(1);
		term.setResources(resource);
//		PkTerm pkTerm = new PkTerm();
//		pkTerm.setIdProject(1);
//		pkTerm.setIdResource(1);
//		term.setPkTerm(pkTerm);
	//	archiveServiceLocal.AddArchiveTerm(term);
	}
}
