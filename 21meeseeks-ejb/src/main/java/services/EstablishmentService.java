package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Establishment;
import interfaces.EstablishmentServiceLocal;
import interfaces.EstablishmentServiceRemote;

/**
 * Session Bean implementation class EstablishmentService
 */
@Stateless
@LocalBean
public class EstablishmentService implements EstablishmentServiceRemote, EstablishmentServiceLocal {
	
	@PersistenceContext(unitName = "21meeseeks-ejb")
	EntityManager em;

    /**
     * Default constructor. 
     */
    public EstablishmentService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int addEstablishment(Establishment e) {
		em.persist(e);
		return e.getIdEstablishment();
	}

	@Override
	public Establishment findEstablishment(int id) {
		Establishment e=em.find(Establishment.class, id);
		return e;
	}

	@Override
	public Boolean deleteEstablishment(int id) {
		Establishment e=em.find(Establishment.class, id);
		try {
			em.remove(e);
			return true;
		} catch (Exception e2) {
			return false;
		}
		
	}

	@Override
	public void updateEstablishment(Establishment e) {
		Establishment establishement=em.find(Establishment.class, e.getIdEstablishment());
		establishement=e;
		em.merge(establishement);
		
	}

	@Override
	public List<Establishment> getAllEstablishment() {
		TypedQuery<Establishment> q = em.createQuery("SELECT e FROM Establishment e", Establishment.class);
		List<Establishment> listEstablishment = q.getResultList();
		return listEstablishment;
	}

}
