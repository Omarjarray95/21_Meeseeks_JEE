package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Competence;
import interfaces.CompetenceServiceLocal;
import interfaces.CompetenceServiceRemote;

/**
 * Session Bean implementation class CompetenceService
 */
@Stateless
@LocalBean
public class CompetenceService implements CompetenceServiceRemote, CompetenceServiceLocal {
	
	@PersistenceContext(unitName = "21meeseeks-ejb")
	EntityManager em;

    /**
     * Default constructor. 
     */
    public CompetenceService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int addCompetence(Competence c) {
		em.persist(c);
		return c.getIdCompetence();
	}

	@Override
	public Competence findCompetence(int id) {
		Competence c=em.find(Competence.class, id);
		return c;
	}

	@Override
	public Boolean deleteCompetence(int id) {
		Competence c=em.find(Competence.class, id);
		em.remove(c);
		return true;
	}

	@Override
	public void updateCompetence(Competence c) {
		Competence comptence=em.find(Competence.class, c.getIdCompetence());
		comptence=c;
		em.merge(comptence);
		
	}

	@Override
	public List<Competence> getAllCompetence() {
		TypedQuery<Competence> q = em.createQuery("SELECT c FROM Competence c", Competence.class);
		List<Competence> listCompetence = q.getResultList();
		return listCompetence;
	}

}
