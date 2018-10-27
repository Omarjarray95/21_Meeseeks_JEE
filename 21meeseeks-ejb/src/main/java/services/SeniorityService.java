package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Seniority;
import interfaces.SeniorityServiceLocal;
import interfaces.SeniorityServiceRemote;

/**
 * Session Bean implementation class SeniorityService
 */
@Stateless
@LocalBean
public class SeniorityService implements SeniorityServiceRemote, SeniorityServiceLocal {

	@PersistenceContext(unitName = "21meeseeks-ejb")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public SeniorityService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addSeniority(Seniority s) {
		em.persist(s);
		return s.getIdSeniority();
	}

	@Override
	public Seniority findSeniority(int id) {
		Seniority s = em.find(Seniority.class, id);
		System.out.println(s.getName());
		return s;
	}

	@Override
	public Boolean deleteSeniority(int id) {
		Seniority s = em.find(Seniority.class, id);
		try {
			em.remove(s);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public void updateSeniority(Seniority s) {

		Seniority seniority = em.find(Seniority.class, s.getIdSeniority());
        seniority=s;
		em.merge(seniority);
		

	}

	@Override
	public List<Seniority> getAllSenority() {
		TypedQuery<Seniority> q = em.createQuery("SELECT c FROM Seniority c", Seniority.class);
		List<Seniority> listSeniority = q.getResultList();
		return listSeniority;
	}

}
