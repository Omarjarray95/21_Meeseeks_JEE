package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Competence;

@Local
public interface CompetenceServiceLocal {
	public int addCompetence(Competence c);
	public Competence findCompetence(int id);
	public Boolean deleteCompetence(int id);
	public void updateCompetence(Competence c);
	public List<Competence> getAllCompetence();

}
