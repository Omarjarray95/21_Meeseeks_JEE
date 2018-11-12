package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import entities.PkTerm;
import entities.Resource;
import entities.Term;
import entities.TermArchive;
import interfaces.ArchiveServiceLocal;
import interfaces.ArchiveServiceRemote;

/**
 * Session Bean implementation class ArchiveService
 */
@Stateless
public class ArchiveService implements ArchiveServiceRemote, ArchiveServiceLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */

	@Override
	public void AddArchiveTerm(Term term) {
		List<Term> list = entityManager.createQuery("select t from Term t  where t.dateEnd < CURRENT_DATE and t.dateEnd < :dateEnd and t.archived=:archive ")
				.setParameter("dateEnd", term.getDateEnd())
				.setParameter("archive", false).getResultList();
		int n = list.size();
		System.out.println("sizeListe = " + n);

		if (!list.isEmpty()) {

			for (Term t : list) {
				TermArchive termArchive = new TermArchive();

				termArchive.setTerm(t);
				entityManager.persist(termArchive);
				t.setArchived(true);
				entityManager.merge(t);
			}
		}
	}

}
