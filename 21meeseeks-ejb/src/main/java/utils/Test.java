package utils;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entities.Competence;
import entities.Resource;
import enums.Availability;

@Startup
@Singleton
public class Test {
	@EJB
	private interfaces.MondatServiceLocal mondatServiceLocal;

	@PostConstruct
	public void init() {

		System.out.println("************************************************************************************");
		Competence competence = new Competence();
		competence.setIdCompetence(1);
		List<Resource> list = mondatServiceLocal.findResourceByCompetenceAndAvailability(competence,
				EnumSet.of(Availability.Available, Availability.AvailableSoon));
		System.out.println("***********************" + list.size());
		


	}
}
