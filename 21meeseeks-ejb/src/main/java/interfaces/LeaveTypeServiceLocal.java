package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.LeaveType;

@Local
public interface LeaveTypeServiceLocal {

	int AddLeaveType(LeaveType lT);
	boolean UpdateLeaveType(LeaveType lT);

	List<LeaveType> ShowAllLeaveTypes();

	boolean DeleteLeaveType(int idLeaveType);

}
