package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Resume;
import interfaces.ResumeServiceLocal;
import interfaces.ResumeServiceRemote;

/**
 * Session Bean implementation class ResumeService
 */
@Stateless
@LocalBean
public class ResumeService implements ResumeServiceRemote, ResumeServiceLocal {

	@PersistenceContext(unitName = "21meeseeks-ejb")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public ResumeService() {

	}

	@Override
	public int addResume(Resume r) {
		em.persist(r);
		return r.getIdResume();
	}

	@Override
	public Resume findResume(int id) {
		Resume r = em.find(Resume.class, id);
		return r;
	}

	@Override
	public Boolean deleteResume(int id) {
		Resume r = em.find(Resume.class, id);
		em.remove(r);
		return true;
	}

	@Override
	public void updateResume(Resume r) {
		Resume resume = em.find(Resume.class, r);
		resume = r;
		em.merge(resume);

	}

	@Override
	public List<Resume> getAllResume() {
		TypedQuery<Resume> q = em.createQuery("SELECT r FROM Resume r", Resume.class);
		List<Resume> listResume = q.getResultList();
		return listResume;
	}

}
