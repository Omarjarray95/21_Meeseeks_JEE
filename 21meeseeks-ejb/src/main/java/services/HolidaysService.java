package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Holidays;
import interfaces.HolidaysServiceLocal;
import interfaces.HolidaysServiceRemote;

/**
 * Session Bean implementation class HolidaysService
 */
@Stateless
@LocalBean
public class HolidaysService implements HolidaysServiceRemote, HolidaysServiceLocal {
	
	@PersistenceContext(unitName = "21meeseeks-ejb")
	EntityManager em;

    /**
     * Default constructor. 
     */
    public HolidaysService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int addHolidays(Holidays h) {
		em.persist(h);
		return h.getIdHolidays();
	}

	@Override
	public Holidays findHolidays(int id) {
		Holidays h=em.find(Holidays.class, id);
		return h;
	}

	@Override
	public Boolean deleteHolidays(int id) {
		Holidays h=em.find(Holidays.class, id);
		em.remove(h);
		return true;
	}

	@Override
	public void updateHolidays(Holidays h) {
		Holidays holidays=em.find(Holidays.class, h.getIdHolidays());
		holidays=h;
		em.merge(holidays);
		
		
	}

	@Override
	public List<Holidays> getAllHolidays() {
		TypedQuery<Holidays> q = em.createQuery("SELECT d FROM Holidays d", Holidays.class);
		List<Holidays> listHolidays = q.getResultList();
		return listHolidays;
	}

}
