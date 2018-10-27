package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Establishment;
import entities.Society;
import interfaces.SocietyServiceLocal;
import interfaces.SocietyServiceRemote;

/**
 * Session Bean implementation class SocietyService
 */
@Stateless
@LocalBean
public class SocietyService implements SocietyServiceRemote, SocietyServiceLocal {
	
	@PersistenceContext(unitName = "21meeseeks-ejb")
	EntityManager em;

    /**
     * Default constructor. 
     */
    public SocietyService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int addSociety(Society e) {
		em.persist(e);
		return e.getIdSociety();
	}

	@Override
	public Society findSociety(int id) {
		Society s=em.find(Society.class, id);
		return s;
	}

	@Override
	public Boolean deleteSociety(int id) {
		Society s=em.find(Society.class, id);
		em.remove(s);
		return true;
	}

	@Override
	public void updateSociety(Society e) {
		Society s=em.find(Society.class, e.getIdSociety());
		s=e;
		em.merge(s);
		
	}

	@Override
	public List<Society> getAllSociety() {
		TypedQuery<Society> q = em.createQuery("SELECT s FROM Society s", Society.class);
		List<Society> listSociety = q.getResultList();
		return listSociety;
	}

}
