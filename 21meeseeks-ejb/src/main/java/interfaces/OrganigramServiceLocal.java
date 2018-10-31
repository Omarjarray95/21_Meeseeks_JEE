package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Organigram;

@Local
public interface OrganigramServiceLocal {

	public Organigram addOrganigram(Organigram o);
	public List<Organigram> showAllOrganigrams();
}
