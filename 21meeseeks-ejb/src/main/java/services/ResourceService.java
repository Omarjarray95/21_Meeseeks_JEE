package services;

import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import interfaces.ResourceServiceLocal;
import interfaces.ResourceServiceRemote;
import entities.DayOff;
import entities.Note;
import entities.Resource;
import entities.Resume;
import entities.Seniority;
import enums.Availability;
import enums.ContractType;

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
		
		
		r.setResume(em.find(Resume.class, r.getResume().getIdResume()));
		r.setSeniority(em.find(Seniority.class, r.getSeniority().getIdSeniority()));
		
		//em.merge(r);
		/*
		Set<Note> noteliste = r.getNotes();
		Note note = em.find(Note.class, r.getNotes().iterator().next().getIdNote());
		noteliste.add(note);
		r.setNotes(noteliste);
		System.out.println(r.getNotes());
		System.out.println(note);
		
		
		DayOff dayOff = em.find(DayOff.class, r.getDayOffs().iterator().next().getIdLeave());
		Set<DayOff> dayOffliste = r.getDayOffs();
		dayOffliste.add(dayOff);
		r.setDayOffs(dayOffliste);
		System.out.println(r.getDayOffs());
		System.out.println(dayOffliste);
		*/
		
		//em.merge(r);
		
		System.out.println(r);
		
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
		try{
			if(r != null){
				Query query = em.createQuery("DELETE Level l WHERE l.resources.idUser=:resources");
				query.setParameter("resources", r.getIdUser()).executeUpdate();
				System.out.println("UPDATING RESOURCE WITH BULLSHITS");
				Query query3 = em.createQuery("UPDATE Resource r SET r.resume = null WHERE r.idUser = :id");
				query3.setParameter("id", r.getIdUser()).executeUpdate();
				Query query4 = em.createQuery("UPDATE Resource s SET s.seniority = null WHERE s.idUser = :id");
				query4.setParameter("id", r.getIdUser()).executeUpdate();
				System.out.println("TERMS DELETING ...");
				Query query5 = em.createQuery("DELETE FROM Term WHERE idResource = :id");
				query5.setParameter("id", r.getIdUser()).executeUpdate();
				System.out.println("TERMS DELETED ");
				r.setSeniority(null);
				System.out.println("Remove Resume");
				//System.out.println(level);
				//em.remove(level);
				em.remove(r);
				System.out.println("Remove Resource");
				
				return true ;
			}
		}catch(NoResultException e){
			
			System.out.println(e.getMessage());
			return false ;
		}
		
		return false;
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
	@Override
	public int lastIndex() {
		try {
			TypedQuery<Integer> index = em
					.createQuery("select max(r.idUser) from Resource r", Integer.class);
			
			return index.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e);
			return 0;
		}
	}
	@Override
	public List<Resource> getResourceByType(ContractType type) {
		return em.createQuery("select r from Resource r where "
				+ "r.contractType=:type", Resource.class)
				.setParameter("type", type).getResultList();
	}
	@Override
	public List<Resource> getResourceByAvaibility(Availability avaib) {
		return em.createQuery("select r from Resource r where "
				+ "r.availability=:avaib", Resource.class)
				.setParameter("avaib", avaib).getResultList();
	}
	
	
}
