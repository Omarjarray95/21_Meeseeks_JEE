package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.LeaveType;
import interfaces.LeaveTypeServiceLocal;
import interfaces.LeaveTypeServiceRemote;

/**
 * Session Bean implementation class LeaveTypeService
 */
@Stateless
@LocalBean
public class LeaveTypeService implements LeaveTypeServiceRemote, LeaveTypeServiceLocal {

	@PersistenceContext(unitName = "21meeseeks-ejb")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public LeaveTypeService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addLeaveType(LeaveType l) {
		em.persist(l);
		return l.getIdLeaveType();
	}

	@Override
	public LeaveType findLeaveType(int id) {
		LeaveType l = em.find(LeaveType.class, id);
		return l;
	}

	@Override
	public Boolean deleteLeaveType(int id) {
		LeaveType l = em.find(LeaveType.class, id);
		em.remove(l);
		return true;
	}

	@Override
	public void updateLeaveType(LeaveType l) {
		LeaveType leaveType = em.find(LeaveType.class, l.getIdLeaveType());
		leaveType = l;
		em.merge(leaveType);

	}

	@Override
	public List<LeaveType> getAllLeaveType() {
		TypedQuery<LeaveType> q = em.createQuery("SELECT l FROM LeaveType l", LeaveType.class);
		List<LeaveType> listLeaveType = q.getResultList();
		return listLeaveType;
	}

}
