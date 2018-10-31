package services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Competence;
import entities.DayOff;
import entities.Resource;
import entities.Term;
import enums.Availability;
import interfaces.MandatServiceLocal;
import interfaces.MandatServiceRemote;
import utils.SendEmail;

/**
 * Session Bean implementation class MondatService
 */
@Stateless
public class MandatService implements MandatServiceRemote, MandatServiceLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	private EntityManager entityManager;

	public MandatService() {

	}

	@Override
	public List<Resource> findResourceByCompetenceAndAvailability(Competence competence,
			EnumSet<Availability> availables) {
		List<Resource> list = entityManager
				.createQuery("select r from Resource r inner join r.levels l where l.competences =:compt "
						+ "and r.availability in :available ")
				.setParameter("available", availables).setParameter("compt", competence).getResultList();

		return list;

	}

	@Override
	public void addTerm(Term term) {

		entityManager.persist(term);

	}

	public int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int workDays = 0;

		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do {
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++workDays;
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis());
		return workDays;
	}

	@Override
	public Term calculateEndDateTerm(Term term) {
		int totalDays = 0;
		Calendar cal = Calendar.getInstance();

		cal.setTime(term.getDateStart());
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date dateDebut = cal.getTime();

		cal.setTime(dateDebut);
		cal.add(Calendar.DAY_OF_MONTH, term.getNumberofDaysTerm());
		Date dateFin = cal.getTime();

		System.out.println("********first*******");
		System.out.println("debut=" + dateDebut);
		System.out.println("fin=" + dateFin);

		dateFin = calculDayWork(dateDebut, dateFin, term.getNumberofDaysTerm());

		List<DayOff> listDayOff = entityManager
				.createQuery("select d from    DayOff  d inner join d.resource r  "
						+ " where d.startDate between  :dateStart and :dateEnd and d.resource=:resource")
				.setParameter("dateStart", term.getDateStart()).setParameter("dateEnd", dateFin)
				.setParameter("resource", term.getResources()).getResultList();

		if (!listDayOff.isEmpty()) {
			System.out.println("**********************congé*************");
			for (DayOff d : listDayOff) {
				if (d.getEndDate().before(dateFin)) {

					LocalDate start = d.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					LocalDate end = d.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					long days = ChronoUnit.DAYS.between(start, end);
					System.out.println("****days**" + days);
					cal.setTime(dateFin);
					cal.add(Calendar.DAY_OF_MONTH, Math.toIntExact(days));

					dateFin = calculDayWork(dateFin, cal.getTime(), Math.toIntExact(days));

				} else {
					LocalDate startD = d.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					LocalDate fin = dateFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					long days = ChronoUnit.DAYS.between(startD, fin);
					cal.setTime(d.getEndDate());
					cal.add(Calendar.DAY_OF_MONTH, Math.toIntExact(days));

					dateFin = calculDayWork(dateFin, cal.getTime(), Math.toIntExact(days));

				}
			}

		}
		term.setDateEnd(dateFin);
		return term;
	}

	private Date calculDayWork(Date dateDebut, Date dateFin, int numberOfDays) {
		Calendar cal = Calendar.getInstance();
		while (numberOfDays != 0) {

			int days = getWorkingDaysBetweenTwoDates(dateDebut, dateFin);

			dateDebut = dateFin;

			cal.setTime(dateFin);
			int rest = numberOfDays - days;
			cal.add(Calendar.DAY_OF_MONTH, rest);
			dateFin = cal.getTime();

			// totalDays += days - rest;

			numberOfDays -= days;
			System.out.println("***************");
			System.out.println("debut=" + dateDebut);
			System.out.println("fin=" + dateFin);
			System.out.println("rest=" + rest);
			System.out.println("days=" + days);
			// System.out.println("total days=" + totalDays);

		}
		return dateFin;

	}

	@Override
	public String testerDateDeb(Resource resource, Term term) {
		Calendar cal = Calendar.getInstance();

		LocalDate endTerm = term.getDateEnd().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate sysdate = cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		long days = ChronoUnit.DAYS.between(endTerm, sysdate);
		if (resource.getAvailability().equals("AvailableSoon")
				| resource.getAvailability().equals(" UnavailableSoon")) {
			cal.add(Calendar.DAY_OF_MONTH, Math.toIntExact(days));
			term.setDateStart(cal.getTime());
			return "Resource est disponible a patir de ce jour la";
		} else if (resource.getAvailability().equals("Available")) {
			return "resource est disponible vous pouvez choisir date debut";
		}
		return "le resource n'est pas disponible";

	}

	@Override
	public float fraisMandat(Term term) {

		// Resource resource = entityManager.find(Resource.class,
		// term.getPkTerm().getIdResource());
		return (float) (((term.getResources().getSalary() / 30) * term.getNumberofDaysTerm()) * 1.8);
	}

	@Override
	public void alerteMandat() {
		List<Term> list = entityManager
				.createQuery("select t from Term t where DATEDIFF( t.dateEnd,CURRENT_DATE )=40", Term.class)
				.getResultList();

		for (Term term : list) {
			if (!term.isSended()) {
				String subject = "Alerte - 40 jours";
				String object = "notification -40jours avant la fin du mandat!!!!!";
				String email = term.getResources().getEmail();
				SendEmail.envoyer(email, subject, object);

				term.setSended(true);
				entityManager.merge(term);
			}
		}
	}
}
