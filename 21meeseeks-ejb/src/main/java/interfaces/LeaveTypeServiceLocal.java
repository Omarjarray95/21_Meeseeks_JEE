package interfaces;

import entities.LeaveType;

public interface LeaveTypeServiceLocal {

	int AddLeaveType(LeaveType lT);
	Boolean updateLeaveType(LeaveType lT);

	String ShowAllLeaveTypes();

	boolean DeleteLeaveType(int idLeaveType);

}
