package services;

import java.util.List;

import interfaces.OrganigramServiceLocal;
import interfaces.OrganigramServiceRemote;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Organigram;
import entities.Project;

/**
 * Session Bean implementation class OrganigramService
 */
@Stateless
@LocalBean
public class OrganigramService implements OrganigramServiceRemote, OrganigramServiceLocal {
	@PersistenceContext(unitName="21meeseeks-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public OrganigramService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Organigram addOrganigram(Organigram o) {
		// TODO Auto-generated method stub
		if(o.getProject()!=null)
		{
			o.setProject(em.find(Project.class, o.getProject().getIdProject()));
		}
		em.persist(o);
		return o;
          
	}

	@Override
	public List<Organigram> showAllOrganigrams() {
		// TODO Auto-generated method stub
		
		TypedQuery<Organigram> query=em.createQuery("SELECT e from Organigram e",Organigram.class);
		List<Organigram> cf=query.getResultList();
		return cf;
		}

}
