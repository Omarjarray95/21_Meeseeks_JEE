package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Certificate;
import interfaces.CertificateServiceLocal;
import interfaces.CertificateServiceRemote;

/**
 * Session Bean implementation class CertificateService
 */
@Stateless
@LocalBean
public class CertificateService implements CertificateServiceRemote, CertificateServiceLocal {

	@PersistenceContext(unitName = "21meeseeks-ejb")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public CertificateService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addCertificate(Certificate c) {
		em.persist(c);
		return c.getIdCertificate();
	}

	@Override
	public Certificate findCertificate(int id) {
		Certificate c = em.find(Certificate.class, id);
		return c;
	}

	@Override
	public Boolean deleteCertificate(int id) {
		Certificate c = em.find(Certificate.class, id);
		em.remove(c);
		return true;
	}

	@Override
	public void updateCertificate(Certificate c) {
		Certificate certificate = em.find(Certificate.class, c.getIdCertificate());
		certificate = c;
		em.merge(certificate);

	}

	@Override
	public List<Certificate> getAllCertificate() {
		TypedQuery<Certificate> q = em.createQuery("SELECT c FROM Certificate c", Certificate.class);
		List<Certificate> listCertificate = q.getResultList();
		return listCertificate;
	}

}
