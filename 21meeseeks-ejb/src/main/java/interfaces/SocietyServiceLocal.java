package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Society;

@Local
public interface SocietyServiceLocal {
	public int addSociety(Society e);
	public Society findSociety(int id);
	public Boolean deleteSociety(int id);
	public void updateSociety(Society e);
	public List<Society> getAllSociety();

}
