package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.DayOff;

@Local
public interface DayOffServieLocal {
	public int addDayOff(DayOff d);
	public DayOff findDayOff(int id);
	public Boolean deleteDayOff(int id);
	public void updateDayOff(DayOff d);
	public List<DayOff> getAllDayOff();

}
