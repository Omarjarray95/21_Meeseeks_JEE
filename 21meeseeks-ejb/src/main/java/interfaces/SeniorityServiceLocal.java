package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Seniority;

@Local
public interface SeniorityServiceLocal {
	
	public int addSeniority(Seniority s);
	public Seniority findSeniority(int id);
	public Boolean deleteSeniority(int id);
	public void updateSeniority(Seniority s);
	public List<Seniority> getAllSenority();
	
	

}
