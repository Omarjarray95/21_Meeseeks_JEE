package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.LeaveType;

@Local
public interface LeaveTypeServiceLocal {
	public int addLeaveType(LeaveType l);
	public LeaveType findLeaveType(int id);
	public Boolean deleteLeaveType(int id);
	public void updateLeaveType(LeaveType l);
	public List<LeaveType> getAllLeaveType();

}
