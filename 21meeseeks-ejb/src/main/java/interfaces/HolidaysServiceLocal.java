package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Holidays;

@Local
public interface HolidaysServiceLocal {
	public int addHolidays(Holidays h);
	public Holidays findHolidays(int id);
	public Boolean deleteHolidays(int id);
	public void updateHolidays(Holidays h);
	public List<Holidays> getAllHolidays();


}
