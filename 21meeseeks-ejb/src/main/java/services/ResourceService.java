package services;

import java.util.List;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import interfaces.ResourceServiceLocal;
import interfaces.ResourceServiceRemote;
import entities.Resource;

/**
 * Session Bean implementation class ResourceService
 */
@Stateless
@LocalBean
public class ResourceService implements ResourceServiceRemote, ResourceServiceLocal {

	@PersistenceContext(unitName="21meeseeks-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public ResourceService() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public int ajoutRessource(Resource r) {
		em.persist(r);
		return r.getIdUser();
	}
	@Override
	public Resource findResource(int id) {
		Resource r=em.find(Resource.class, id);
		return r;
	}
	@Override
	public Boolean deleteResource(int id) {
		Resource r=em.find(Resource.class, id);
		em.remove(r);
		return true;
	}
	@Override
	public void updateResource(Resource r) {
		Resource resource=em.find(Resource.class, r.getIdUser());
		resource=r;
		em.merge(resource);
		
	}
	@Override
	public List<Resource> getAllResource() {
		TypedQuery<Resource> q = em.createQuery("SELECT r FROM Resource r", Resource.class);
		List<Resource> listResource = q.getResultList();
		return listResource;
	}

}
